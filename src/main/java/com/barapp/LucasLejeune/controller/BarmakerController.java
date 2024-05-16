package com.barapp.LucasLejeune.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.barapp.LucasLejeune.model.Barmaker;
import com.barapp.LucasLejeune.service.BarmakerService;

@RestController
@RequestMapping("/barmakers")
@CrossOrigin(origins = "http://localhost:5173")
public class BarmakerController {
    @Autowired
    private BarmakerService barmakerService;
    
    @PostMapping
    public ResponseEntity<Barmaker> createBarmaker(@RequestBody Barmaker barmaker) {
        Barmaker createdBarmaker = barmakerService.createBarmaker(barmaker);
        return new ResponseEntity<>(createdBarmaker, HttpStatus.CREATED);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Barmaker> getBarmaker(@PathVariable int id) {
        Barmaker barmaker = barmakerService.getBarmaker(id);
        if (barmaker == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(barmaker, HttpStatus.OK);
    }

    @GetMapping
    public List<Barmaker> getAllBarmakers(){
        return barmakerService.getBarmakers();
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<Barmaker> updateBarmaker(@PathVariable Integer id, @RequestBody Barmaker barmaker) {
        Barmaker existingBarmaker = barmakerService.getBarmaker(id);
        if (existingBarmaker == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        Barmaker updatedBarmaker = barmakerService.updateBarmaker(barmaker);
        return new ResponseEntity<>(updatedBarmaker, HttpStatus.OK);
    }
}
