package edu.mum.cs.serveremployee.service;

import java.util.List;

import edu.mum.cs.serveremployee.domain.Book;

public interface BookService {
    List<Book> getBookList();
    Book saveBook(Book book);
    Book getBookById(Long bookid);
}
