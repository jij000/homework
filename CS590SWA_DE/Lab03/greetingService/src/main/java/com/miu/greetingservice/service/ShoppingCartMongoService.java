package com.miu.greetingservice.service;

import java.util.List;

import com.miu.greetingservice.domian.ShoppingCart;
import com.miu.greetingservice.repository.ShoppingCartRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ShoppingCartMongoService {
    @Autowired
    ShoppingCartRepository shoppingCartRepository;
        
    public void addShoppingCart(ShoppingCart shoppingCart){
        shoppingCartRepository.insert(shoppingCart);
    }
    public void deleteShoppingCart(String id){
        shoppingCartRepository.deleteById(id);
    }
    public ShoppingCart getShoppingCart(String id){
        return shoppingCartRepository.findById(id).get();
    }
    public List<ShoppingCart> getAllShoppingCarts(){
        return shoppingCartRepository.findAll();
    } 
}