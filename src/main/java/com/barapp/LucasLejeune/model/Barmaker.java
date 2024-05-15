package com.barapp.LucasLejeune.model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Barmaker {
    @Id
    private Integer id;
    private String name;
    private String password;
    @OneToMany(mappedBy = "barmaker_id", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Card> cards;
    
    public int getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public String getPassword() {
        return password;
    }

    public void setId(int id){
        this.id = id;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setPassword(String password) {
        this.password = password;
    }
}
