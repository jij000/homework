package edu.mum.cs.serveremployee.controller;

import java.util.ArrayList;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import edu.mum.cs.serveremployee.domain.Book;
import edu.mum.cs.serveremployee.domain.Review;
import edu.mum.cs.serveremployee.service.BookService;

@Controller
public class ReviewController {
    @Autowired
    private BookService bookService;

    //REST method
    @PostMapping("/saveReview/{bookid}")
    @ResponseBody
    public Review saveReview(@Valid @RequestBody Review review, @PathVariable Long bookid) {
        Book book = bookService.getBookById(bookid);
        if (book.getReviews() == null) {
            book.setReviews(new ArrayList<Review>());
        }
        book.getReviews().add(review);
        book = bookService.saveBook(book);
        return review;
    }

}
