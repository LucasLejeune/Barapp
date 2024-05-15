package com.barapp.LucasLejeune.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.barapp.LucasLejeune.model.Barmaker;
import com.barapp.LucasLejeune.repository.BarmakerRepository;
import com.barapp.LucasLejeune.service.BarmakerService;

@Service
public class BarmakerServiceImpl implements BarmakerService{
    @Autowired
    private BarmakerRepository barmakerRepository;

    @Override
    public Barmaker createBarmaker(Barmaker barmaker) {
        return barmakerRepository.save(barmaker);
    }

    @Override
    public Barmaker getBarmaker(int id) {
        return barmakerRepository.findById(id).orElse(null);
    }

    @Override
    public Barmaker getBarmakerByName(String name) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getBarmakerByName'");
    }

    @Override
    public Barmaker updateBarmaker(Barmaker barmaker) {
        return barmakerRepository.save(barmaker);
    }

    @Override
    public List<Barmaker> getBarmakers() {
        return barmakerRepository.findAll();
    }
}
