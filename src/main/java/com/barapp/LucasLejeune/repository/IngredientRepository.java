package com.barapp.LucasLejeune.repository;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

import com.barapp.LucasLejeune.model.Ingredient;

@Repository
public interface IngredientRepository extends JpaRepository<Ingredient, Integer> {
}
