package com.barapp.LucasLejeune.model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class ClientTable {
    @Id
    private Integer id;
    private String name;
    @ManyToOne
    @JoinColumn(name = "card_id")
    private Card card_id;
    @OneToMany(mappedBy = "table_id", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Command> commands;

    public int getId() {
        return id;
    }
    public String getName() {
        return name;
    }

    public Card getCard() {
        return card_id;
    }
    public void setCard(Card card) {
        this.card_id = card;
    }
    public void setId(int id){
        this.id = id;
    }
    public void setName(String name) {
        this.name = name;
    }
}
