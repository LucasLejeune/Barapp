package com.barapp.LucasLejeune.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.barapp.LucasLejeune.model.Barmaker;

@Repository
public interface BarmakerRepository extends JpaRepository<Barmaker, Integer>{

}
