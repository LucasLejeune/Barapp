package com.barapp.LucasLejeune.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.barapp.LucasLejeune.model.Card;
import com.barapp.LucasLejeune.service.TableService;

@Service
public class TableServiceImpl implements TableService{

    @Override
    public Card createCard(int barmaker_id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'createCard'");
    }

    @Override
    public Card getCard(int id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getCard'");
    }

    @Override
    public Card getCardByName(String name) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getCardByName'");
    }

    @Override
    public Card updateCard(Card card) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'updateCard'");
    }

    @Override
    public List<Card> getCards() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getCards'");
    }
    
}
