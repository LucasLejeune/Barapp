package com.barapp.LucasLejeune.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.barapp.LucasLejeune.model.Card;
import com.barapp.LucasLejeune.model.ClientTable;
import com.barapp.LucasLejeune.repository.CardRepository;
import com.barapp.LucasLejeune.repository.TableRepository;
import com.barapp.LucasLejeune.service.TableService;

import jakarta.persistence.EntityNotFoundException;

@Service
public class TableServiceImpl implements TableService{
    @Autowired
    private CardRepository cardRepository;
    @Autowired
    private TableRepository tableRepository;

    @Override
    public ClientTable createTable(int card_id, String name) {
        Card card = cardRepository.findById(card_id).orElseThrow(() -> new EntityNotFoundException("Card not found"));
        ClientTable table = new ClientTable();
        table.setId(0);
        table.setCard(card);
        table.setName(name);
        return tableRepository.save(table);
    }

    @Override
    public ClientTable getTable(int id) {
        return tableRepository.findById(id).orElse(null);
    }

    @Override
    public ClientTable updateTable(ClientTable table) {
        return tableRepository.save(table);
    }

    @Override
    public List<ClientTable> getTables() {
        return tableRepository.findAll();
    }

    
}
