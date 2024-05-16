package com.barapp.LucasLejeune.controller;

import com.barapp.LucasLejeune.service.CocktailService;

import com.barapp.LucasLejeune.model.Cocktail;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/cocktails")
@CrossOrigin(origins = "http://localhost:5173")
public class CocktailController {
    @Autowired
    private CocktailService cocktailService;
    
    @PostMapping
    public ResponseEntity<Cocktail> createCocktail(@RequestBody Cocktail cocktail) {
        Cocktail createdCocktail = cocktailService.createCocktail(cocktail);
        return new ResponseEntity<>(createdCocktail, HttpStatus.CREATED);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Cocktail> getCocktail(@PathVariable int id) {
        Cocktail cocktail = cocktailService.getCocktail(id);
        if (cocktail == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(cocktail, HttpStatus.OK);
    }

    @GetMapping
    public List<Cocktail> getAllCocktails(){
        return cocktailService.getCocktails();
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<Cocktail> updateCocktail(@PathVariable Integer id, @RequestBody Cocktail cocktail) {
        Cocktail existingCocktail = cocktailService.getCocktail(id);
        if (existingCocktail == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        Cocktail updatedCocktail = cocktailService.updateCocktail(cocktail);
        return new ResponseEntity<>(updatedCocktail, HttpStatus.OK);
    }
}
