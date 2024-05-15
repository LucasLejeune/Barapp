package com.barapp.LucasLejeune.service;

import java.util.List;

import com.barapp.LucasLejeune.model.CocktailIngredients;

public interface CocktailIngredientsService {
    CocktailIngredients createCocktailIngredients(int ingredient_id, int cocktail_id);
    CocktailIngredients getCocktailIngredients(int id);
    CocktailIngredients updateCocktailIngredients(CocktailIngredients cocktailIngredients);
    List<CocktailIngredients> getAllCocktailIngredients();
}
