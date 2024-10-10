package com.example.numtkinoxp.controller;

import com.example.numtkinoxp.model.Seat;
import com.example.numtkinoxp.model.Ticket;
import com.example.numtkinoxp.repository.SeatRepository;
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
public class SeatRESTcontroller {

    @Autowired
    SeatRepository seatRepository;


    @GetMapping("/seat")
    public List<Seat> getSeats() {
        return seatRepository.findAll();
    }

    @GetMapping("/seat/{id}/ticket")
    public ResponseEntity<Set<Ticket>> getTicketFromId(@PathVariable int id){
        Optional<Seat> seatOptional = seatRepository.findById(id);
        if(seatOptional.isPresent()){
            Seat seat = seatOptional.get();
            return ResponseEntity.ok(seat.getTickets());
        }else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

}
