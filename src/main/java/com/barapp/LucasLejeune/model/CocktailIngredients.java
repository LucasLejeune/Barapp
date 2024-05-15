package com.barapp.LucasLejeune.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class CocktailIngredients {
    @Id
    private int id;
    
    @ManyToOne
    @JoinColumn(name = "ingredient_id")
    private Ingredient ingredient_id;

    @ManyToOne
    @JoinColumn(name = "cocktail_id")
    private Cocktail cocktail_id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Ingredient getIngredient_id() {
        return ingredient_id;
    }

    public void setIngredient_id(Ingredient ingredient_id) {
        this.ingredient_id = ingredient_id;
    }

    public Cocktail getCocktail_id() {
        return cocktail_id;
    }

    public void setCocktail_id(Cocktail cocktail_id) {
        this.cocktail_id = cocktail_id;
    }

    
}
