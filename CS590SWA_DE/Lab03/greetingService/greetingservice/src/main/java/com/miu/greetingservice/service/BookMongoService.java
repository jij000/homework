package com.miu.greetingservice.service;

import java.util.List;

import com.miu.greetingservice.domian.Book;
import com.miu.greetingservice.repository.BookRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookMongoService {
    @Autowired
    BookRepository bookRepository;
        
    public void addBook(Book book){
        bookRepository.insert(book);
    }
    public void deleteBook(String isbn){
        bookRepository.deleteById(isbn);
    }
    public Book getBook(String isbn){
        return bookRepository.findById(isbn).get();
    }
    public List<Book> getAllBooks(){
        return bookRepository.findAll();
    } 
}