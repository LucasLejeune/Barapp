package com.barapp.LucasLejeune.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.barapp.LucasLejeune.model.CardCocktail;

@Repository
public interface CardCocktailRepository extends JpaRepository<CardCocktail, Integer>{

}
