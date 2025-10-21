package com.arssekal.learnTransaction.service;

import com.arssekal.learnTransaction.model.Author;
import com.arssekal.learnTransaction.repo.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorService {
    @Autowired
    private AuthorRepository authorRepository;

    public List<Author> getAllAuthors() {
        return authorRepository.findAll();
    }
    public Author addAuthor(Author author) {
        return authorRepository.save(author);
    }
    public Author getAuthorById(int id) {
        return authorRepository.findById(id).orElseThrow(() -> new RuntimeException("author not found"));
    }
    public Author updateAuthor(int id, String name) {
        Author author = authorRepository.findById(id).orElseThrow(() -> new RuntimeException("author not found"));
        author.setName(name);
        return authorRepository.save(author);
    }
    public void deleteAuthor(int id) {
        Author author = authorRepository.findById(id).orElseThrow(() -> new RuntimeException("author not found"));
        authorRepository.delete(author);
    }
}
