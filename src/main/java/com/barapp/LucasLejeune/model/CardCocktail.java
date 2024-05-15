package com.barapp.LucasLejeune.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class CardCocktail {
    @Id
    private Integer id;

    private String cocktail_size;

    private Float cocktail_price;

    @ManyToOne
    @JoinColumn(name = "card_id")
    private Card card_id;

    @ManyToOne
    @JoinColumn(name = "cocktail_id")
    private Cocktail cocktail_id;

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getCocktail_size() {
        return cocktail_size;
    }
    public void setCocktail_size(String cocktail_size) {
        this.cocktail_size = cocktail_size;
    }
    public Float getCocktail_price() {
        return cocktail_price;
    }
    public void setCocktail_price(Float cocktail_price) {
        this.cocktail_price = cocktail_price;
    }
    public Card getCard_id() {
        return card_id;
    }
    public void setCard_id(Card card_id) {
        this.card_id = card_id;
    }
    public Cocktail getCocktail_id() {
        return cocktail_id;
    }
    public void setCocktail_id(Cocktail cocktail_id) {
        this.cocktail_id = cocktail_id;
    }
}
