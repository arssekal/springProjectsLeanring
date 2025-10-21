package com.arssekal.learnTransaction.service;

import com.arssekal.learnTransaction.model.Author;
import com.arssekal.learnTransaction.model.Book;
import com.arssekal.learnTransaction.model.Category;
import com.arssekal.learnTransaction.repo.AuthorRepository;
import com.arssekal.learnTransaction.repo.BookRepository;
import com.arssekal.learnTransaction.repo.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookService {
    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private AuthorRepository authorRepository;
    @Autowired
    private CategoryRepository categoryRepository;

    public Book addBook(Book book, int authorID) {
        Author author = authorRepository.findById(authorID).orElseThrow(() -> new RuntimeException("author not found"));
        book.setAuthor(author);

        return bookRepository.save(book);
    }

    public Book getBookById(int id) {
        return bookRepository.findById(id).orElseThrow(() -> new RuntimeException("book not found"));
    }

    public Book deleteBook(int id) {
        Book book = bookRepository.findById(id).orElseThrow(() -> new RuntimeException("book not found"));
        bookRepository.delete(book);
        return book;
    }

    public List<Book> getBooksByAuthor(int authorId) {
        List<Book> booksByAuthor = new ArrayList<>();
        bookRepository.findAll().forEach((book) -> {
            if(authorId == book.getAuthor().getId()) booksByAuthor.add(book);
        });
        return  booksByAuthor;
    }

    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    public Book upadteBook(int id, Book newBook) {
        Book book = bookRepository.findById(id).orElseThrow(() -> new RuntimeException("book not found"));
        book.setTitle(newBook.getTitle());

        Author author = authorRepository.findById(newBook.getAuthor().getId()).orElseThrow(() -> new RuntimeException("author not found"));
        book.setAuthor(author);

        book.setCategories(newBook.getCategories());
        return bookRepository.save(book);
    }
    @Transactional // garantit que tout est validé ou rollbacké si une exception survient.
    public Book addBookWithCategories(Book book, int authorId, List<Integer> categoryIds) {
        Author author = authorRepository.findById(authorId).orElseThrow(() -> new RuntimeException("author not found"));
        book.setAuthor(author);
        List<Category> categories = new ArrayList<>();
        for(int id : categoryIds) {
            Category category = categoryRepository.findById(id).orElseThrow(() -> new RuntimeException("Category not found"));
            categories.add(category);
        }
        book.setCategories(categories);

        return bookRepository.save(book);
    }
}
