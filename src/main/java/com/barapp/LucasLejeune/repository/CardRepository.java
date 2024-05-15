package com.barapp.LucasLejeune.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.barapp.LucasLejeune.model.Card;

@Repository
public interface CardRepository extends JpaRepository<Card, Integer>{
    
}
