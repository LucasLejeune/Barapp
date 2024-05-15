package com.barapp.LucasLejeune.service;

import java.util.List;

import com.barapp.LucasLejeune.model.CardCocktail;

public interface CardCocktailService {
    CardCocktail createCardCocktail(int card_id, int cocktail_id, String cocktailSize, Float cocktailPrice);
    CardCocktail getCardCocktail(int id);
    CardCocktail updateCardCocktail(CardCocktail cardCocktail);
    List<CardCocktail> getCardCocktails();
}
