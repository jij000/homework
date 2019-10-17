package edu.mum.cs.serveremployee.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import edu.mum.cs.serveremployee.domain.Book;
import edu.mum.cs.serveremployee.service.BookService;

@Controller
public class BookController {
    @Autowired
    private BookService bookService;

    @GetMapping(path = {"/", "/getBookList"})
    public String getBookList(@ModelAttribute Book book, Model model) {
        List<Book> books = bookService.getBookList();
        model.addAttribute("books", books);
        return "BookList";
    }

    @PostMapping("/addBook")
    public String addBook(@Valid Book book, BindingResult result, Model model) {
        if(result.hasErrors()){
            return "BookList";
        }else{
            book = bookService.saveBook(book);
            return "redirect:getBookList";
        }
    }

    @GetMapping("/getBookDetail/{bookid}")
    public String getBookDetail(@PathVariable Long bookid, Model model) {
        model.addAttribute("book", bookService.getBookById(bookid));
        // model.addAttribute("reviews", reviewService.getReviewList());
        return "BookDetail";
    }

}
