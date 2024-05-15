package com.barapp.LucasLejeune.service;

import java.util.List;

import com.barapp.LucasLejeune.model.Barmaker;

public interface BarmakerService {
    Barmaker createBarmaker(Barmaker barmaker);
    Barmaker getBarmaker(int id);
    Barmaker getBarmakerByName(String name);
    Barmaker updateBarmaker(Barmaker barmaker);
    List<Barmaker> getBarmakers();
}
