package com.arssekal.learnTransaction.repo;

import com.arssekal.learnTransaction.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Integer> {
}
