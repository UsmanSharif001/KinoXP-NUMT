package com.example.numtkinoxp.controller;

import com.example.numtkinoxp.model.Ticket;
import com.example.numtkinoxp.repository.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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
