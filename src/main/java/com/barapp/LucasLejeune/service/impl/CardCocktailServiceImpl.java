package com.barapp.LucasLejeune.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.barapp.LucasLejeune.model.Card;
import com.barapp.LucasLejeune.model.CardCocktail;
import com.barapp.LucasLejeune.model.Cocktail;
import com.barapp.LucasLejeune.repository.CardCocktailRepository;
import com.barapp.LucasLejeune.repository.CardRepository;
import com.barapp.LucasLejeune.repository.CocktailRepository;
import com.barapp.LucasLejeune.service.CardCocktailService;

import jakarta.persistence.EntityNotFoundException;

@Service
public class CardCocktailServiceImpl implements CardCocktailService {
    @Autowired
    private CardRepository cardRepository;
    @Autowired
    private CocktailRepository cocktailRepository;
    @Autowired
    private CardCocktailRepository cardCocktailRepository;


    @Override
    public CardCocktail createCardCocktail(int card_id, int cocktail_id, String cocktailSize, Float cocktailPrice ) {
        Card card = cardRepository.findById(card_id).orElseThrow(() -> new EntityNotFoundException("Card not found"));
        Cocktail cocktail = cocktailRepository.findById(cocktail_id).orElseThrow(() -> new EntityNotFoundException("Cocktail not found"));
        CardCocktail cardCocktail = new CardCocktail();
        cardCocktail.setId(0);
        cardCocktail.setCard_id(card);
        cardCocktail.setCocktail_price(cocktailPrice);
        cardCocktail.setCocktail_size(cocktailSize);
        cardCocktail.setCocktail_id(cocktail);
        return cardCocktailRepository.save(cardCocktail);
    }

    @Override
    public CardCocktail getCardCocktail(int id) {
        return cardCocktailRepository.findById(id).orElse(null);
    }

    @Override
    public CardCocktail updateCardCocktail(CardCocktail cardCocktail) {
        return cardCocktailRepository.save(cardCocktail);
    }

    @Override
    public List<CardCocktail> getCardCocktails() {
        return cardCocktailRepository.findAll();
    }
    
}
