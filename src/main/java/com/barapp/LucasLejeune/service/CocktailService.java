package com.barapp.LucasLejeune.service;

import java.util.List;

import com.barapp.LucasLejeune.model.Cocktail;

public interface CocktailService {
    Cocktail createCocktail(Cocktail cocktail);
    Cocktail getCocktail(int id);
    Cocktail getCocktailByName(String name);
    Cocktail updateCocktail(Cocktail cocktail);
    List<Cocktail> getCocktails();
}
