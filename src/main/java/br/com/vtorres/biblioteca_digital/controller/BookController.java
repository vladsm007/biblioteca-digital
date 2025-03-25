package br.com.vtorres.biblioteca_digital.controller;

import br.com.vtorres.biblioteca_digital.entities.Book;
import br.com.vtorres.biblioteca_digital.service.BookServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/books")
public class BookController {

    @Autowired
    private BookServiceImpl bookService;

    @PostMapping("/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable Long id) {
       Book book = bookService.getBookById(id);
       return ResponseEntity.ok(book);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Book> updateBook(@PathVariable Long id, @RequestBody Book book) {
        Book updatedBook = bookService.updateBook(id, book);
        return ResponseEntity.ok(updatedBook);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBook(@PathVariable Long id) {
        bookService.deleteBook(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/search")
    public ResponseEntity<List<Book>> findBookByName(@RequestParam String name) {
        List<Book> books = bookService.findBookByName(name);
        return ResponseEntity.ok(books);
    }
}
