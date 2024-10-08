package com.example.numtkinoxp.controller;

import com.example.numtkinoxp.model.Cinema;
import com.example.numtkinoxp.model.Movie;
import com.example.numtkinoxp.repository.CinemaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins = "*")

@RestController
public class CinemaRESTcontroller {

    @Autowired
    CinemaRepository cinemaRepository;

    @GetMapping("/cinema")
    public List<Cinema> getCinema() {
        return cinemaRepository.findAll();
    }



}
