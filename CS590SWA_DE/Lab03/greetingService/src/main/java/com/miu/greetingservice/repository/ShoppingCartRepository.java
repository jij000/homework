package com.miu.greetingservice.repository;

import com.miu.greetingservice.domian.ShoppingCart;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShoppingCartRepository extends MongoRepository<ShoppingCart, String>{

}