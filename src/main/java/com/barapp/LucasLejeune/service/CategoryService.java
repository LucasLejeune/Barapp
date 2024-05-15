package com.barapp.LucasLejeune.service;

import java.util.List;

import com.barapp.LucasLejeune.model.Category;

public interface CategoryService {
    Category createCategory(Category Category);
    Category getCategory(int id);
    Category getCategoryByName(String name);
    Category updateCategory(Category Category);
    List<Category> getCategories();
}
