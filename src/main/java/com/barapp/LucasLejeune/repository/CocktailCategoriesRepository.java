package com.barapp.LucasLejeune.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.barapp.LucasLejeune.model.CocktailCategories;

@Repository
public interface CocktailCategoriesRepository extends JpaRepository<CocktailCategories, Integer>{
    
}
