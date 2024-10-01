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
        m1.setTitle("Verdens bedste film");
        m1.setRunningTime(120);
        m1.setDescription("Fed film, dette er en beskrivelse");
        m1.setRecommendedAge(12);
        m1.setIs3D(false);
        m1.setActive(true);
        m1.setHrefImage("Flot billede");
        movieRepository.save(m1);

        Movie m2 = new Movie();
        m2.setTitle("Film 2");
        m2.setRunningTime(140);
        m2.setDescription("Fed film, dette er en beskrivelse for film2");
        m2.setRecommendedAge(5);
        m2.setIs3D(true);
        m2.setActive(true);
        m2.setHrefImage("Flot billede igen igen");
        movieRepository.save(m2);

        Cinema c1 = new Cinema();
        c1.setName("Bio 1");
        cinemaRepository.save(c1);

        Screening s1 = new Screening();
        s1.setDate(LocalDate.of(24,10,1));
        s1.setTimeOfDay(LocalTime.of(18,30));
        s1.setCinema(c1);
        s1.setMovie(m1);
        screeningRepository.save(s1);

        Screening s2 = new Screening();
        s2.setDate(LocalDate.of(2024,12,1));
        s2.setTimeOfDay(LocalTime.of(18,30));
        s2.setCinema(c1);
        s2.setMovie(m2);
        screeningRepository.save(s2);

        Seat seat1 = new Seat();
        seat1.setRowNr(10);
        seat1.setSeatNr(10);
        seat1.setPrice(100);
        seat1.setReserved(true);
        seat1.setCinema(c1);
        seatRepository.save(seat1);

        Seat seat2 = new Seat();
        seat2.setRowNr(10);
        seat2.setSeatNr(11);
        seat2.setPrice(150);
        seat2.setReserved(true);
        seat2.setCinema(c1);
        seatRepository.save(seat2);

        Ticket t1 = new Ticket();
        t1.setCustomerName("Niko");
        t1.setSeat(seat1);
        t1.setScreening(s1);
        ticketRepository.save(t1);

        Ticket t2 = new Ticket();
        t2.setCustomerName("Mogens");
        t2.setSeat(seat2);
        t2.setScreening(s2);
        ticketRepository.save(t2);


    }

}
