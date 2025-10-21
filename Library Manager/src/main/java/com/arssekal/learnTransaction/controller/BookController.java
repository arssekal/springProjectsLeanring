package com.arssekal.learnTransaction.controller;

import com.arssekal.learnTransaction.model.Book;
import com.arssekal.learnTransaction.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {
    @Autowired
    private BookService bookService;

    @PostMapping("/{id}")
    public ResponseEntity<Book> addBook(@RequestBody Book book, @PathVariable("id") int author_id) {
        Book savedBook = bookService.addBook(book, author_id);
        return  new ResponseEntity<>(savedBook, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Book>> getAllBooks() {
        return ResponseEntity.ok(bookService.getAllBooks());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable int id) {
        Book book;
        try {
            book = bookService.getBookById(id);
            return new ResponseEntity<>(book, HttpStatus.OK);
        }
        catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @PutMapping("/{id}")
    public ResponseEntity<Book> updateBook(@PathVariable int id, @RequestBody Book newBook) {
        Book book;
        try {
            book = bookService.upadteBook(id, newBook);
            return new ResponseEntity<>(book, HttpStatus.OK);
        }
        catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteBook(@PathVariable int id) {
        try {
            bookService.deleteBook(id);
            return new ResponseEntity<>("book deleted successfully", HttpStatus.OK);
        }
        catch (RuntimeException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }
    @GetMapping("/author/{authorId}")
    public ResponseEntity<List<Book>> getBooksByAuthor(@PathVariable("authorId") int id) {
        List<Book> booksByAuthor = bookService.getBooksByAuthor(id);
        return ResponseEntity.ok(booksByAuthor);
    }

}
