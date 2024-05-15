package com.barapp.LucasLejeune.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.barapp.LucasLejeune.model.CocktailIngredients;

@Repository
public interface CocktailIngredientsRepository extends JpaRepository<CocktailIngredients, Integer> {
    
}
