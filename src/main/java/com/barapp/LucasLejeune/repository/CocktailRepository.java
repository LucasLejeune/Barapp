package com.barapp.LucasLejeune.repository;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

import com.barapp.LucasLejeune.model.Cocktail;

@Repository
public interface CocktailRepository extends JpaRepository<Cocktail, Integer>{
}
