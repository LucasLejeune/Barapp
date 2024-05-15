package com.barapp.LucasLejeune.service;

import java.util.List;

import com.barapp.LucasLejeune.model.Card;

public interface CardService {
    Card createCard(int barmaker_id);
    Card getCard(int id);
    Card getCardByName(String name);
    Card updateCard(Card card);
    List<Card> getCards();
}
