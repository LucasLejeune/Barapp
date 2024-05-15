package com.barapp.LucasLejeune.model;

import jakarta.persistence.Embeddable;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
@Embeddable
public class CommandCocktail {
    @Id
    private int id;
    private String status;
    
    @ManyToOne
    @JoinColumn(name = "command_id")
    private Command command_id;

    @ManyToOne
    @JoinColumn(name = "cocktail_id")
    private Cocktail cocktail_id;


    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Command getCommand_id() {
        return command_id;
    }

    public void setCommand_id(Command command_id) {
        this.command_id = command_id;
    }

    public Cocktail getCocktail_id() {
        return cocktail_id;
    }

    public void setCocktail_id(Cocktail cocktail_id) {
        this.cocktail_id = cocktail_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
