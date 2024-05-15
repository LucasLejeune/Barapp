package com.barapp.LucasLejeune.service.impl;

import com.barapp.LucasLejeune.model.Cocktail;
import com.barapp.LucasLejeune.repository.CocktailRepository;
import com.barapp.LucasLejeune.service.CocktailService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class CocktailServiceImpl implements CocktailService{
    @Autowired
    private CocktailRepository cocktailRepository;

    @Override
    public Cocktail createCocktail(Cocktail cocktail){
        return cocktailRepository.save(cocktail);
    }
    
    @Override
    public Cocktail getCocktail(int id) {
        return cocktailRepository.findById(id).orElse(null);
    }
    
    @Override
    public Cocktail updateCocktail(Cocktail cocktail) {
        return cocktailRepository.save(cocktail);
    }

    @Override
    public Cocktail getCocktailByName(String name) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getCocktailByName'");
    }

    @Override
    public List<Cocktail> getCocktails() {
        return cocktailRepository.findAll();
    }

}
