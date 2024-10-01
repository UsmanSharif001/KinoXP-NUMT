package com.example.numtkinoxp.config;

import com.example.numtkinoxp.model.*;
import com.example.numtkinoxp.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalTime;

@Component
public class InitData implements CommandLineRunner {

    @Autowired
    CinemaRepository cinemaRepository;
    @Autowired
    MovieRepository movieRepository;
    @Autowired
    ScreeningRepository screeningRepository;
    @Autowired
    SeatRepository seatRepository;
    @Autowired
    TicketRepository ticketRepository;

    @Override
    public void run(String... args) throws Exception {

        Movie m1 = new Movie();
        m1.setRunningTime(120);
        m1.setDescription("Fed film");
        m1.setRecommendedAge(12);
        m1.setIs3D(false);
        m1.setActive(true);
        m1.setHrefImage("Flot billede");
        movieRepository.save(m1);

        Cinema c1 = new Cinema();
        c1.setName("Bio 1");
        cinemaRepository.save(c1);

        Screening s1 = new Screening();
        s1.setDate(LocalDate.of(24,10,1));
        s1.setTimeOfDay(LocalTime.of(18,30));
        s1.setCinema(c1);
        s1.setMovie(m1);
        screeningRepository.save(s1);

        Seat seat1 = new Seat();
        seat1.setRowNr(10);
        seat1.setSeatNr(10);
        seat1.setPrice(100);
        seat1.setReserved(true);
        seat1.setCinema(c1);
        seatRepository.save(seat1);

        Ticket t1 = new Ticket();
        t1.setCustomerName("Niko");
        t1.setSeat(seat1);
        t1.setScreening(s1);
        ticketRepository.save(t1);


    }

}
