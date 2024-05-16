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

import com.barapp.LucasLejeune.model.ClientTable;
import com.barapp.LucasLejeune.service.TableService;

@RestController
@RequestMapping("/tables")
@CrossOrigin(origins = "http://localhost:5173")
public class TableController {
    @Autowired
    private TableService tableService;
    
    @PostMapping("/{cardId}")
    public ResponseEntity<ClientTable> createTable(@RequestBody TableRequest tableRequest) {
        ClientTable createdTable = tableService.createTable(tableRequest.getCardId(), tableRequest.getName());
        return new ResponseEntity<>(createdTable, HttpStatus.CREATED);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<ClientTable> getTable(@PathVariable int id) {
        ClientTable table = tableService.getTable(id);
        if (table == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(table, HttpStatus.OK);
    }

    @GetMapping
    public List<ClientTable> getAllTables(){
        return tableService.getTables();
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<ClientTable> updateTable(@PathVariable Integer id, @RequestBody ClientTable table) {
        ClientTable existingTable = tableService.getTable(id);
        if (existingTable == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        ClientTable updatedTable = tableService.updateTable(table);
        return new ResponseEntity<>(updatedTable, HttpStatus.OK);
    }
}

class TableRequest {
    private int cardId;
    private String name;

    public int getCardId() {
        return cardId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCardId(int cardId) {
        this.cardId = cardId;
    }

    
}
