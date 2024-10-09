package com.example.numtkinoxp.controller;

import com.example.numtkinoxp.model.Ticket;
import com.example.numtkinoxp.repository.TicketRepository;
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
public class TicketRESTcontroller {

    @Autowired
    TicketRepository ticketRepository;

    @GetMapping("/ticket")
    public List<Ticket> ticketList() {
        return ticketRepository.findAll();
    }


}
