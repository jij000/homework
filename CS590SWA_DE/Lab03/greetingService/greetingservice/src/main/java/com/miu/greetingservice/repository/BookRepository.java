package com.miu.greetingservice.repository;

import com.miu.greetingservice.domian.Book;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends MongoRepository<Book, String>{

}