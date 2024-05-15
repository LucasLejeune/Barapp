package com.barapp.LucasLejeune.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.barapp.LucasLejeune.model.Category;
import com.barapp.LucasLejeune.model.Cocktail;
import com.barapp.LucasLejeune.model.CocktailCategories;
import com.barapp.LucasLejeune.repository.CategoryRepository;
import com.barapp.LucasLejeune.repository.CocktailCategoriesRepository;
import com.barapp.LucasLejeune.repository.CocktailRepository;
import com.barapp.LucasLejeune.service.CocktailCategoriesService;

import jakarta.persistence.EntityNotFoundException;

@Service
public class CocktailCategoriesServiceImpl implements CocktailCategoriesService {
    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private CocktailRepository cocktailRepository;
    @Autowired
    private CocktailCategoriesRepository cardCocktailRepository;


    @Override
    public CocktailCategories createCocktailCategories(int category_id, int cocktail_id) {
        Category category = categoryRepository.findById(category_id).orElseThrow(() -> new EntityNotFoundException("category not found"));
        Cocktail cocktail = cocktailRepository.findById(cocktail_id).orElseThrow(() -> new EntityNotFoundException("Cocktail not found"));
        CocktailCategories cocktailCategories = new CocktailCategories();
        cocktailCategories.setId(0);
        cocktailCategories.setCategory_id(category);
        cocktailCategories.setCocktail_id(cocktail);
        return cardCocktailRepository.save(cocktailCategories);
    }

    @Override
    public CocktailCategories getCocktailCategories(int id) {
        return cardCocktailRepository.findById(id).orElse(null);
    }

    @Override
    public CocktailCategories updateCocktailCategories(CocktailCategories cocktailCategories) {
        return cardCocktailRepository.save(cocktailCategories);
    }

    @Override
    public List<CocktailCategories> getAllCocktailCategories() {
        return cardCocktailRepository.findAll();
    }
    
}
