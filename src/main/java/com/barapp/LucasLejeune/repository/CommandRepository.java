package com.barapp.LucasLejeune.repository;

import org.springframework.stereotype.Repository;

import com.barapp.LucasLejeune.model.Command;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface CommandRepository extends JpaRepository<Command, Integer> {
    
}
