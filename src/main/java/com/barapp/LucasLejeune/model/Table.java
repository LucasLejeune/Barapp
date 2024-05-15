package com.barapp.LucasLejeune.model;

import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

public class Table {
    @Id
    private Integer id;
    private String name;
    @ManyToOne
    @JoinColumn(name = "card_id")
    private Card card_id;

    
    
    public int getId() {
        return id;
    }
    public String getName() {
        return name;
    }

    public void setId(int id){
        this.id = id;
    }
    public void setName(String name) {
        this.name = name;
    }
}
