package com.example.numtkinoxp.repository;

import com.example.numtkinoxp.model.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketRepository extends JpaRepository<Ticket, String> {

}
