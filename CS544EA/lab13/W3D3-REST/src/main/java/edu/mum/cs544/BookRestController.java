package edu.mum.cs544;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class BookRestController {
    @Resource
    private BookService bookService;

    @GetMapping("/books")
    public List<Book> getAll() {
        return bookService.getAll();
    }
    @GetMapping("/books/{id}")
    public Book get(@PathVariable int id) {
        return bookService.get(id);
    }

    @PostMapping("/books")
    public RedirectView add(@RequestBody Book book) {
        bookService.add(book);
        return new RedirectView("/books/" + book.getId());
    }
    @PutMapping("/books/{id}")
    public void update(@PathVariable long id, @RequestBody Book book) {
        if (id != book.getId()) { throw new IllegalArgumentException(); }
        bookService.update(book);
    }
    @DeleteMapping("/books/{id}")
    public void delete(@PathVariable int id) {
        bookService.delete(id);
    }
}
