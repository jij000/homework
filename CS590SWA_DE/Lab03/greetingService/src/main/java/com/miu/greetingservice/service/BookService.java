package com.miu.greetingservice.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

import com.miu.greetingservice.domian.Book;

import org.springframework.stereotype.Service;

@Service
public class BookService {
    private List<Book> bookList = new ArrayList<>();
    
    public void addBook(Book book){
        bookList.add(book);
    }
    public void deleteBook(String isbn){
        Iterator<Book> ib = this.bookList.iterator();
        while (ib.hasNext()) {
            Book b = ib.next();
            if (isbn.equals(b.getIsbn())) {
                ib.remove();
            }
        }
    }
    public Book getBook(String isbn){
        List<Book> bookList1 = this.bookList.stream().filter(x->isbn.equals(x.getIsbn())).collect(Collectors.toList());
        return bookList1.size() > 0 ? bookList1.get(0) : null;
    }
    public List<Book> getAllBooks(){
        return this.bookList;
    } 
}