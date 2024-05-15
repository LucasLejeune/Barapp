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

import com.barapp.LucasLejeune.model.CocktailCategories;
import com.barapp.LucasLejeune.service.CocktailCategoriesService;

@RestController
@RequestMapping("/cocktailCategories")
public class CocktailCategoriesController {
    @Autowired
    private CocktailCategoriesService cocktailCategoriesService;

    @PostMapping
    public ResponseEntity<CocktailCategories> createCard(@RequestBody CocktailCategoriesRequest cocktailCategoriesRequest) {
        CocktailCategories createdCommandCocktail = cocktailCategoriesService.createCocktailCategories(cocktailCategoriesRequest.getCategory_id(), cocktailCategoriesRequest.getCocktail_id());
        return new ResponseEntity<>(createdCommandCocktail, HttpStatus.CREATED);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<CocktailCategories> getCard(@PathVariable int id) {
        CocktailCategories commandCocktail = cocktailCategoriesService.getCocktailCategories(id);
        if (commandCocktail == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(commandCocktail, HttpStatus.OK);
    }

    @GetMapping
    public List<CocktailCategories> getAllCards(){
        return cocktailCategoriesService.getAllCocktailCategories();
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<CocktailCategories> updateCard(@PathVariable Integer id, @RequestBody CocktailCategories cocktailCategories) {
        CocktailCategories existingCommandCocktail = cocktailCategoriesService.getCocktailCategories(id);
        if (existingCommandCocktail == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        CocktailCategories updatedCard = cocktailCategoriesService.updateCocktailCategories(cocktailCategories);
        return new ResponseEntity<>(updatedCard, HttpStatus.OK);
    }
}

class CocktailCategoriesRequest {
    private int category_id;
    private int cocktail_id;

    public int getCategory_id() {
        return category_id;
    }
    public void setCategory_id(int category_id) {
        this.category_id = category_id;
    }
    public int getCocktail_id() {
        return cocktail_id;
    }
    public void setCocktail_id(int cocktail_id) {
        this.cocktail_id = cocktail_id;
    }
    
}