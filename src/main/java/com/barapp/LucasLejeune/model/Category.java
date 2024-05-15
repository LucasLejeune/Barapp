package com.barapp.LucasLejeune.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Category {
    @Id
    private Integer id;
    private String name;
    
    
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
