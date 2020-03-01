package com.miu.greetingservice.controller;

import java.util.List;

import com.miu.greetingservice.domian.Product;
import com.miu.greetingservice.service.ProductMongoService;
import com.miu.greetingservice.service.ShoppingCartMongoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/webshop")
public class WebshopController {
    @Autowired
    ProductMongoService productMongoService;
    @Autowired
    ShoppingCartMongoService shoppingCartMongoService;

    @RequestMapping("/add")
    public ResponseEntity<?> addBook(@RequestBody Product product) {
        productMongoService.addProduct(product);
        return new ResponseEntity<Product>(HttpStatus.OK);
    }
    @RequestMapping("/del/{isbn}")
    public ResponseEntity<?> delBook(@PathVariable("isbn") String isbn) {
        productMongoService.deleteProduct(isbn);
        return new ResponseEntity<Product>(HttpStatus.OK);
    }
    @RequestMapping("/get/{id}")
    public ResponseEntity<?> getBook(@PathVariable("id") String id) {
        Product product = productMongoService.getProduct(id);
        return new ResponseEntity<Product>(product, HttpStatus.OK);
    }
    @RequestMapping("/getall")
    public ResponseEntity<?> getGreeting() {
        List<Product> products = productMongoService.getAllProducts();
        return new ResponseEntity<List<Product>>(products, HttpStatus.OK);
    }
}