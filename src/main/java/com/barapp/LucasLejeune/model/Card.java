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
public class Card {
    @Id
    private int id;

    @ManyToOne
    @JoinColumn(name = "barmaker_id")
    private Barmaker barmaker_id;
    
    @OneToMany(mappedBy = "card_id", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<ClientTable> tables;
    
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public Barmaker getBarmaker() {
        return barmaker_id;
    }
    public void setBarmaker(Barmaker barmaker) {
        this.barmaker_id = barmaker;
    }

    
}
