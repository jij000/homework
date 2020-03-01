package com.miu.greetingservice.service;

import java.util.List;

import com.miu.greetingservice.domian.Product;
import com.miu.greetingservice.repository.ProductRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductMongoService {
    @Autowired
    ProductRepository productRepository;
        
    public void addProduct(Product product){
        productRepository.insert(product);
    }
    public void setProductStock(String id, String quantity, String locationCode){
        Product product = productRepository.findById(id).get();
        product.setQuantity(quantity);
        product.setLocationCode(locationCode);
        productRepository.save(product);
    }
    public void deleteProduct(String id){
        productRepository.deleteById(id);
    }
    public Product getProduct(String id){
        return productRepository.findById(id).get();
    }
    public List<Product> getAllProducts(){
        return productRepository.findAll();
    } 
}