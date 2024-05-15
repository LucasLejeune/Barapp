package com.barapp.LucasLejeune.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.barapp.LucasLejeune.model.Barmaker;
import com.barapp.LucasLejeune.model.Card;
import com.barapp.LucasLejeune.repository.BarmakerRepository;
import com.barapp.LucasLejeune.repository.CardRepository;
import com.barapp.LucasLejeune.service.CardService;

import jakarta.persistence.EntityNotFoundException;

@Service
public class CardServiceImpl implements CardService {
    @Autowired
    private CardRepository cardRepository;
    @Autowired
    private BarmakerRepository barmakerRepository;

    @Override
    public Card createCard(int barmakerId) {
        Barmaker barmaker = barmakerRepository.findById(barmakerId).orElseThrow(() -> new EntityNotFoundException("Barmaker not found"));
        Card card = new Card();
        card.setBarmaker(barmaker);
        return cardRepository.save(card);
    }

    @Override
    public Card getCard(int id) {
        return cardRepository.findById(id).orElse(null);
    }

    @Override
    public Card getCardByName(String name) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getCardByName'");
    }

    @Override
    public Card updateCard(Card card) {
        return cardRepository.save(card);
    }

    @Override
    public List<Card> getCards() {
        return cardRepository.findAll();
    }
}
