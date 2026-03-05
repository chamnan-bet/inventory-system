package com.example.inventory_system.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.inventory_system.entities.Category;
import com.example.inventory_system.repository.CategoryRepository;

@Service
public class CategoryService {
    private final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public List<Category> findAll() {
        return categoryRepository.findByStatus(1);
    }

    public Category saveCategory(Category category) {
        return categoryRepository.save(category);
    }

    public Category findById(Long id) {
        return categoryRepository
                .findByCategoryIdAndStatus(id, 1)
                .orElseThrow(() -> new RuntimeException("Category not found"));
    }

    public void update(Long id, Category updatedCategory) {
        Category existing = findById(id);
        existing.setName(updatedCategory.getName());
        existing.setDescription(updatedCategory.getDescription());
        categoryRepository.save(existing);
    }

    public void deleteById(Long categoryId) {
        Category category = categoryRepository.findById(categoryId)
                .orElseThrow(() -> new RuntimeException("Category not found"));

        category.setStatus(0);
        categoryRepository.save(category);
    }

}
