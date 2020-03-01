package com.miu.greetingservice.controller;

import java.util.List;

import com.miu.greetingservice.domian.Book;
import com.miu.greetingservice.service.BookService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/book")
public class BookController {
    @Autowired
    BookService bookService;

    @RequestMapping("/add")
    public ResponseEntity<?> addBook(@RequestBody Book book) {
        bookService.addBook(book);
        return new ResponseEntity<Book>(HttpStatus.OK);
    }
    @RequestMapping("/del/{isbn}")
    public ResponseEntity<?> delBook(@PathVariable("isbn") String isbn) {
        bookService.deleteBook(isbn);
        return new ResponseEntity<Book>(HttpStatus.OK);
    }
    @RequestMapping("/get/{isbn}")
    public ResponseEntity<?> getBook(@PathVariable("isbn") String isbn) {
        Book book = bookService.getBook(isbn);
        return new ResponseEntity<Book>(book, HttpStatus.OK);
    }
    @RequestMapping("/getall")
    public ResponseEntity<?> getGreeting() {
        List<Book> books = bookService.getAllBooks();
        return new ResponseEntity<List<Book>>(books, HttpStatus.OK);
    }
}