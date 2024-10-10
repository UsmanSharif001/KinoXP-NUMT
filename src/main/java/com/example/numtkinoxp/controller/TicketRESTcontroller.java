package com.example.numtkinoxp.controller;

import com.example.numtkinoxp.model.Ticket;
import com.example.numtkinoxp.repository.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@CrossOrigin(origins = "*")
@RestController
public class TicketRESTcontroller {

    @Autowired
    TicketRepository ticketRepository;

    @GetMapping("/ticket")
    public List<Ticket> ticketList() {
        return ticketRepository.findAll();
    }
    @PostMapping("/postticket")
    public ResponseEntity<Ticket> postTicket(@RequestBody Ticket ticket) {
        System.out.println("Indsætter ny Ticket" + ticket);
        Ticket savedTicket = ticketRepository.save(ticket);
        if (savedTicket == null) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        } else {
            return new ResponseEntity<>(savedTicket, HttpStatus.CREATED);
        }
    }


}
