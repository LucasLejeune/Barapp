package com.barapp.LucasLejeune.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.barapp.LucasLejeune.model.Cocktail;
import com.barapp.LucasLejeune.model.Command;
import com.barapp.LucasLejeune.model.CommandCocktail;
import com.barapp.LucasLejeune.repository.CocktailRepository;
import com.barapp.LucasLejeune.repository.CommandCocktailRepository;
import com.barapp.LucasLejeune.repository.CommandRepository;
import com.barapp.LucasLejeune.service.CommandCocktailService;

import jakarta.persistence.EntityNotFoundException;

@Service
public class CommandCocktailServiceImpl implements CommandCocktailService{
    @Autowired
    private CommandRepository commandRepository;
    @Autowired
    private CocktailRepository cocktailRepository;
    @Autowired
    private CommandCocktailRepository commandCocktailRepository;


    @Override
    public CommandCocktail createCommandCocktail(int command_id, int cocktail_id, String status, String cocktail_size) {
        Command command = commandRepository.findById(command_id).orElseThrow(() -> new EntityNotFoundException("Command not found"));
        Cocktail cocktail = cocktailRepository.findById(cocktail_id).orElseThrow(() -> new EntityNotFoundException("Cocktail not found"));
        CommandCocktail commandCocktail = new CommandCocktail();
        commandCocktail.setId(0);
        commandCocktail.setCommand_id(command);
        commandCocktail.setCocktail_id(cocktail);
        commandCocktail.setStatus(status);
        commandCocktail.setCocktail_size(cocktail_size);
        return commandCocktailRepository.save(commandCocktail);
    }

    @Override
    public CommandCocktail getCommandCocktail(int id) {
        return commandCocktailRepository.findById(id).orElse(null);
    }

    @Override
    public CommandCocktail updateCommandCocktail(CommandCocktail commandCocktail) {
        return commandCocktailRepository.save(commandCocktail);
    }

    @Override
    public List<CommandCocktail> getCommandCocktails() {
        return commandCocktailRepository.findAll();
    }
}
