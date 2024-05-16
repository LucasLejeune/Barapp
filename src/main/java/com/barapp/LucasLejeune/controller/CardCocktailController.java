package com.barapp.LucasLejeune.controller;

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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.barapp.LucasLejeune.model.CardCocktail;
import com.barapp.LucasLejeune.service.CardCocktailService;

@RestController
@RequestMapping("/cardCocktail")
@CrossOrigin(origins = "http://localhost:5173")
public class CardCocktailController {
    @Autowired
    private CardCocktailService cardCocktailService;
    
    @PostMapping
    public ResponseEntity<CardCocktail> createCard(@RequestBody CardCocktailRequest cardCocktailRequest) {
        CardCocktail createdCardCocktail = cardCocktailService.createCardCocktail(cardCocktailRequest.getCard_id(), cardCocktailRequest.getCocktail_id(), cardCocktailRequest.getCocktailSize(), cardCocktailRequest.getCocktailPrice());
        return new ResponseEntity<>(createdCardCocktail, HttpStatus.CREATED);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<CardCocktail> getCard(@PathVariable int id) {
        CardCocktail card = cardCocktailService.getCardCocktail(id);
        if (card == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(card, HttpStatus.OK);
    }

    @GetMapping
    public List<CardCocktail> getAllCards(){
        return cardCocktailService.getCardCocktails();
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<CardCocktail> updateCard(@PathVariable Integer id, @RequestBody CardCocktail card) {
        CardCocktail existingCard = cardCocktailService.getCardCocktail(id);
        if (existingCard == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        CardCocktail updatedCard = cardCocktailService.updateCardCocktail(card);
        return new ResponseEntity<>(updatedCard, HttpStatus.OK);
    }
}

class CardCocktailRequest {
    private int card_id;
    private int cocktail_id;
    private String cocktailSize;
    private Float cocktailPrice;

    public int getCard_id() {
        return card_id;
    }
    public void setCard_id(int card_id) {
        this.card_id = card_id;
    }
    public int getCocktail_id() {
        return cocktail_id;
    }
    public void setCocktail_id(int cocktail_id) {
        this.cocktail_id = cocktail_id;
    }
    public String getCocktailSize() {
        return cocktailSize;
    }
    public void setCocktailSize(String cocktailSize) {
        this.cocktailSize = cocktailSize;
    }
    public Float getCocktailPrice() {
        return cocktailPrice;
    }
    public void setCocktailPrice(Float cocktailPrice) {
        this.cocktailPrice = cocktailPrice;
    }
    
}
