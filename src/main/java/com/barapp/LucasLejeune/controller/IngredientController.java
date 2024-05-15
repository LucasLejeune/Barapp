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

import com.barapp.LucasLejeune.model.Ingredient;
import com.barapp.LucasLejeune.service.IngredientService;

@RestController
@RequestMapping("/ingredients")
public class IngredientController {
    @Autowired
    private IngredientService ingredientService;

    @PostMapping
    public ResponseEntity<Ingredient> createIngredient(@RequestBody Ingredient ingredient) {
        Ingredient createdIngredient = ingredientService.createIngredient(ingredient);
        return new ResponseEntity<>(createdIngredient, HttpStatus.CREATED);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Ingredient> getIngredient(@PathVariable int id) {
        Ingredient Ingredient = ingredientService.getIngredient(id);
        if (Ingredient == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(Ingredient, HttpStatus.OK);
    }

    @GetMapping
    public List<Ingredient> getAllIngredients(){
        return ingredientService.getIngredients();
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<Ingredient> updateIngredient(@PathVariable Integer id, @RequestBody Ingredient ingredient) {
        Ingredient existingIngredient = ingredientService.getIngredient(id);
        if (existingIngredient == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        Ingredient updatedIngredient = ingredientService.updateIngredient(ingredient);
        return new ResponseEntity<>(updatedIngredient, HttpStatus.OK);
    }
}
