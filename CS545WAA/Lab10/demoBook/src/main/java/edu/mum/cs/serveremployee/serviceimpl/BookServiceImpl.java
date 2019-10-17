package edu.mum.cs.serveremployee.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.mum.cs.serveremployee.domain.Book;
import edu.mum.cs.serveremployee.repository.BookRepository;
import edu.mum.cs.serveremployee.service.BookService;

@Service
public class BookServiceImpl implements BookService {
    @Autowired
    private BookRepository bookRepository;

    @Override
    public List<Book> getBookList() {
        return bookRepository.findAll();
    }

    @Override
    public Book saveBook(Book book) {
       return bookRepository.save(book);
    }

    @Override
    public Book getBookById(Long bookid) {
        return bookRepository.findById(bookid).get();
    }
}
