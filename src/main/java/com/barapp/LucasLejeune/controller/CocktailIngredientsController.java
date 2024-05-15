package com.barapp.LucasLejeune.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.barapp.LucasLejeune.model.CocktailIngredients;
import com.barapp.LucasLejeune.service.CocktailIngredientsService;

@RestController
@RequestMapping("/cocktailIngredients")
public class CocktailIngredientsController {
    @Autowired
    private CocktailIngredientsService cocktailIngredientsService;

    @PostMapping
    public ResponseEntity<CocktailIngredients> createCard(@RequestBody CocktailIngredientsRequest cocktailIngredientsRequest) {
        CocktailIngredients createdCommandCocktail = cocktailIngredientsService.createCocktailIngredients(cocktailIngredientsRequest.getIngredient_id(), cocktailIngredientsRequest.getCocktail_id());
        return new ResponseEntity<>(createdCommandCocktail, HttpStatus.CREATED);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<CocktailIngredients> getCard(@PathVariable int id) {
        CocktailIngredients commandCocktail = cocktailIngredientsService.getCocktailIngredients(id);
        if (commandCocktail == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(commandCocktail, HttpStatus.OK);
    }

    @GetMapping
    public List<CocktailIngredients> getAllCards(){
        return cocktailIngredientsService.getAllCocktailIngredients();
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<CocktailIngredients> updateCard(@PathVariable Integer id, @RequestBody CocktailIngredients cocktailIngredients) {
        CocktailIngredients existingCocktailIngredients = cocktailIngredientsService.getCocktailIngredients(id);
        if (existingCocktailIngredients == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        CocktailIngredients updatedCocktailIngredients = cocktailIngredientsService.updateCocktailIngredients(cocktailIngredients);
        return new ResponseEntity<>(updatedCocktailIngredients, HttpStatus.OK);
    }
}

class CocktailIngredientsRequest {
    private int ingredient_id;
    private int cocktail_id;

    public int getCocktail_id() {
        return cocktail_id;
    }
    public void setCocktail_id(int cocktail_id) {
        this.cocktail_id = cocktail_id;
    }
    public int getIngredient_id() {
        return ingredient_id;
    }
    public void setIngredient_id(int ingredient_id) {
        this.ingredient_id = ingredient_id;
    }
    
}