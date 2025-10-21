package com.arssekal.learnTransaction.service;

import com.arssekal.learnTransaction.model.Category;
import com.arssekal.learnTransaction.repo.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;

    public Category  addCategory(Category category) {
        return categoryRepository.save(category);
    }
    public Category getCategoryById(int id){
        return categoryRepository.findById(id).orElseThrow(() -> new RuntimeException("Category not found"));
    }
    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }
    public Category updateCategory(int id, Category newCategory) {
        Category category = categoryRepository.findById(id).orElseThrow(() -> new RuntimeException("Category not found"));
        category.setName(newCategory.getName());
        return categoryRepository.save(category);
    }
    public void deleteCategory(int id) {
        if(!categoryRepository.existsById(id)) {
            throw new RuntimeException("Category not found");
        }
        categoryRepository.deleteById(id);
    }
}
