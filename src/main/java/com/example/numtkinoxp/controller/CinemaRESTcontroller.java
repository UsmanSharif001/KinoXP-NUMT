package com.example.numtkinoxp.controller;

import com.example.numtkinoxp.model.Cinema;
import com.example.numtkinoxp.model.Movie;
import com.example.numtkinoxp.model.Seat;
import com.example.numtkinoxp.repository.CinemaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@CrossOrigin(origins = "*")
@RestController
public class CinemaRESTcontroller {

    @Autowired
    CinemaRepository cinemaRepository;

    @GetMapping("/cinema")
    public List<Cinema> getCinema() {
        return cinemaRepository.findAll();
    }

    @GetMapping("/cinema/{id}/seat")
    public ResponseEntity<Set<Seat>> getSeatFromId(@PathVariable int id){
        Optional<Cinema> seatOptional = cinemaRepository.findById(id);
        if(seatOptional.isPresent()){
            Cinema cinema = seatOptional.get();
            return ResponseEntity.ok(cinema.getSeats());
        }else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }



}
