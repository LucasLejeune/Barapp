package com.barapp.LucasLejeune.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.barapp.LucasLejeune.model.CardCocktail;

@Repository
public interface CardCocktailRepository extends JpaRepository<CardCocktail, Integer>{
    
}
