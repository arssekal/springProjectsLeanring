package com.arssekal.learnTransaction.repo;

import com.arssekal.learnTransaction.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Integer> {
}
