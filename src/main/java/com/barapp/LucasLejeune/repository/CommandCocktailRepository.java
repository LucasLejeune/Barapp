package com.barapp.LucasLejeune.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.barapp.LucasLejeune.model.CommandCocktail;

@Repository
public interface CommandCocktailRepository extends JpaRepository<CommandCocktail, Integer>{
    
}
