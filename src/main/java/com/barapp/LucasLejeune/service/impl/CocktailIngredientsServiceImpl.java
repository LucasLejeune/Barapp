package com.barapp.LucasLejeune.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.barapp.LucasLejeune.model.Cocktail;
import com.barapp.LucasLejeune.model.CocktailIngredients;
import com.barapp.LucasLejeune.model.Ingredient;
import com.barapp.LucasLejeune.repository.CocktailIngredientsRepository;
import com.barapp.LucasLejeune.repository.CocktailRepository;
import com.barapp.LucasLejeune.repository.IngredientRepository;
import com.barapp.LucasLejeune.service.CocktailIngredientsService;

import jakarta.persistence.EntityNotFoundException;

@Service
public class CocktailIngredientsServiceImpl implements CocktailIngredientsService {
    @Autowired
    private IngredientRepository ingredientRepository;
    @Autowired
    private CocktailRepository cocktailRepository;
    @Autowired
    private CocktailIngredientsRepository cocktailIngredientsRepository;

    @Override
    public CocktailIngredients createCocktailIngredients(int ingredient_id, int cocktail_id) {
        Ingredient ingredient = ingredientRepository.findById(ingredient_id).orElseThrow(() -> new EntityNotFoundException("category not found"));
        Cocktail cocktail = cocktailRepository.findById(cocktail_id).orElseThrow(() -> new EntityNotFoundException("Cocktail not found"));
        CocktailIngredients cocktailIngredients = new CocktailIngredients();
        cocktailIngredients.setId(0);
        cocktailIngredients.setIngredient_id(ingredient);
        cocktailIngredients.setCocktail_id(cocktail);
        return cocktailIngredientsRepository.save(cocktailIngredients);
    }
    @Override
    public CocktailIngredients getCocktailIngredients(int id) {
        return cocktailIngredientsRepository.findById(id).orElse(null);
    }
    @Override
    public CocktailIngredients updateCocktailIngredients(CocktailIngredients cocktailCategories) {
        return cocktailIngredientsRepository.save(cocktailCategories);
    }
    @Override
    public List<CocktailIngredients> getAllCocktailIngredients() {
        return cocktailIngredientsRepository.findAll();
    }

    
}
