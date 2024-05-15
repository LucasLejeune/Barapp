package com.barapp.LucasLejeune.service;

import java.util.List;

import com.barapp.LucasLejeune.model.Ingredient;

public interface IngredientService {
    Ingredient createIngredient(Ingredient Ingredient);
    Ingredient getIngredient(int id);
    Ingredient getIngredientByName(String name);
    Ingredient updateIngredient(Ingredient Ingredient);
    List<Ingredient> getIngredients();
}
