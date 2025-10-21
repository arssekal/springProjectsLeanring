package com.arssekal.learnTransaction.repo;

import com.arssekal.learnTransaction.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author, Integer> {
}
