package com.barapp.LucasLejeune.repository;

import org.springframework.stereotype.Repository;

import com.barapp.LucasLejeune.model.Table;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface TableRepository extends JpaRepository<Table,Integer>{
    
}
