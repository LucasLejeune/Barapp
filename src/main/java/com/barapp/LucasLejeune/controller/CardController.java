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

import com.barapp.LucasLejeune.model.Card;
import com.barapp.LucasLejeune.service.CardService;

@RestController
@RequestMapping("/cards")
public class CardController {
    @Autowired
    private CardService cardService;
    
    @PostMapping("/{barmakerId}")
    public ResponseEntity<Card> createCard(@RequestBody CardRequest cardRequest) {
        Card createdCard = cardService.createCard(cardRequest.getBarmakerId());
        return new ResponseEntity<>(createdCard, HttpStatus.CREATED);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Card> getCard(@PathVariable int id) {
        Card card = cardService.getCard(id);
        if (card == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(card, HttpStatus.OK);
    }

    @GetMapping
    public List<Card> getAllCards(){
        return cardService.getCards();
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<Card> updateCard(@PathVariable Integer id, @RequestBody Card card) {
        Card existingCard = cardService.getCard(id);
        if (existingCard == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        Card updatedCard = cardService.updateCard(card);
        return new ResponseEntity<>(updatedCard, HttpStatus.OK);
    }
}

class CardRequest {
    private int barmakerId;

    public int getBarmakerId() {
        return barmakerId;
    }

    public void setBarmakerId(int barmakerId) {
        this.barmakerId = barmakerId;
    }
}
