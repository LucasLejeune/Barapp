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

import com.barapp.LucasLejeune.model.CommandCocktail;
import com.barapp.LucasLejeune.service.CommandCocktailService;

@RestController
@RequestMapping("/commandCocktail")
@CrossOrigin(origins = "http://localhost:5173")
public class CommandCocktailController {
    @Autowired
    private CommandCocktailService commandCocktailService;
    
    @PostMapping
    public ResponseEntity<CommandCocktail> createCard(@RequestBody CommandCocktailRequest commandCocktailRequest) {
        CommandCocktail createdCommandCocktail = commandCocktailService.createCommandCocktail(commandCocktailRequest.getCommand_id(), commandCocktailRequest.getCocktail_id(), commandCocktailRequest.getStatus(), commandCocktailRequest.getCocktail_size());
        return new ResponseEntity<>(createdCommandCocktail, HttpStatus.CREATED);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<CommandCocktail> getCard(@PathVariable int id) {
        CommandCocktail commandCocktail = commandCocktailService.getCommandCocktail(id);
        if (commandCocktail == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(commandCocktail, HttpStatus.OK);
    }

    @GetMapping
    public List<CommandCocktail> getAllCards(){
        return commandCocktailService.getCommandCocktails();
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<CommandCocktail> updateCard(@PathVariable Integer id, @RequestBody CommandCocktail card) {
        CommandCocktail existingCommandCocktail = commandCocktailService.getCommandCocktail(id);
        if (existingCommandCocktail == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        CommandCocktail updatedCard = commandCocktailService.updateCommandCocktail(card);
        return new ResponseEntity<>(updatedCard, HttpStatus.OK);
    }
}

class CommandCocktailRequest {
    private int command_id;
    private int cocktail_id;
    private String status;
    private String cocktail_size;

    public int getCocktail_id() {
        return cocktail_id;
    }
    public void setCocktail_id(int cocktail_id) {
        this.cocktail_id = cocktail_id;
    }
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    public int getCommand_id() {
        return command_id;
    }
    public void setCommand_id(int command_id) {
        this.command_id = command_id;
    }
    public String getCocktail_size() {
        return cocktail_size;
    }
    public void setCocktail_size(String cocktail_size) {
        this.cocktail_size = cocktail_size;
    }

    
}