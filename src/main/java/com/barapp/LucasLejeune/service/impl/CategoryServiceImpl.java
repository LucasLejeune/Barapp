package com.barapp.LucasLejeune.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.barapp.LucasLejeune.model.Category;
import com.barapp.LucasLejeune.repository.CategoryRepository;
import com.barapp.LucasLejeune.service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService{

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public Category createCategory(Category category) {
        return categoryRepository.save(category);
    }

    @Override
    public Category getCategory(int id) {
        return categoryRepository.findById(id).orElse(null);
    }

    @Override
    public Category getCategoryByName(String name) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getCategoryByName'");
    }

    @Override
    public Category updateCategory(Category category) {
        return categoryRepository.save(category);
        
    }

    @Override
    public List<Category> getCategories() {
        return categoryRepository.findAll();
    }
    
}
