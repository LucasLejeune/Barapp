package com.barapp.LucasLejeune.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class CocktailCategories {
    @Id
    private int id;
    
    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category_id;

    @ManyToOne
    @JoinColumn(name = "cocktail_id")
    private Cocktail cocktail_id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Category getCategory_id() {
        return category_id;
    }

    public void setCategory_id(Category category_id) {
        this.category_id = category_id;
    }

    public Cocktail getCocktail_id() {
        return cocktail_id;
    }

    public void setCocktail_id(Cocktail cocktail_id) {
        this.cocktail_id = cocktail_id;
    }
    
}
