package com.barapp.LucasLejeune.service;

import java.util.List;

import com.barapp.LucasLejeune.model.CommandCocktail;

public interface CommandCocktailService {
    CommandCocktail createCommandCocktail(int command_id, int cocktail_id, String status, String cocktail_size);
    CommandCocktail getCommandCocktail(int id);
    CommandCocktail updateCommandCocktail(CommandCocktail cardCocktail);
    List<CommandCocktail> getCommandCocktails();
}
