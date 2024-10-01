package com.example.numtkinoxp.controller;

import com.example.numtkinoxp.repository.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TicketRESTcontroller {

    @Autowired
    TicketRepository ticketRepository;

}
