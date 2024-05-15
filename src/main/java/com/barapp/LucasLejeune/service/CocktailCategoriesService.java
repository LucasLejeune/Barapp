package com.barapp.LucasLejeune.service;

import java.util.List;

import com.barapp.LucasLejeune.model.CocktailCategories;

public interface CocktailCategoriesService {
    CocktailCategories createCocktailCategories(int category_id, int cocktail_id);
    CocktailCategories getCocktailCategories(int id);
    CocktailCategories updateCocktailCategories(CocktailCategories cocktailCategories);
    List<CocktailCategories> getAllCocktailCategories();
}
