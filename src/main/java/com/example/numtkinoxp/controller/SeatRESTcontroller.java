package com.example.numtkinoxp.controller;

import com.example.numtkinoxp.model.Seat;
import com.example.numtkinoxp.repository.SeatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
public class SeatRESTcontroller {

    @Autowired
    SeatRepository seatRepository;


    @GetMapping("/seat")
    public List<Seat> getSeats() {
        return seatRepository.findAll();
    }
}
