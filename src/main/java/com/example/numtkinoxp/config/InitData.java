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
        m1.setTitle("Stalker");
        m1.setRunningTime(162);
        m1.setDescription("A guide leads two men through an area known as the Zone to find a room that grants wishes.");
        m1.setRecommendedAge(12);
        m1.setIs3D(false);
        m1.setActive(true);
        m1.setHrefImage("https://flxt.tmsimg.com/assets/p17498_p_v8_ai.jpg");
        movieRepository.save(m1);

        Movie m2 = new Movie();
        m2.setTitle("The Castle of Cagliostro");
        m2.setRunningTime(102);
        m2.setDescription("A dashing thief, his gang of desperadoes and an intrepid cop struggle to free a princess from an evil count, and learn the secret of a treasure that she holds part of the key to.");
        m2.setRecommendedAge(5);
        m2.setIs3D(true);
        m2.setActive(true);
        m2.setHrefImage("https://flxt.tmsimg.com/assets/p8116000_p_v10_ab.jpg");
        movieRepository.save(m2);

        Movie m3 = new Movie();
        m3.setTitle("Chopping Mall");
        m3.setRunningTime(77);
        m3.setDescription("A group of young shopping mall employees stay behind for a late night party in one of the stores. When the mall goes on lock-down before they can get out, the robot security system malfunctions, and goes on a killing spree.");
        m3.setRecommendedAge(5);
        m3.setIs3D(true);
        m3.setActive(true);
        m3.setHrefImage("https://images.justwatch.com/poster/302571743/s718/chopping-mall.%7Bformat%7D");
        movieRepository.save(m3);

        // Bio 1 / large theater

        Cinema c1 = new Cinema();
        c1.setName("Bio 1");
        cinemaRepository.save(c1);

        // Bio 2 / small theater

        Cinema c2 = new Cinema();
        c2.setName("Bio 2");
        cinemaRepository.save(c2);

        Screening s1 = new Screening();
        s1.setDate(LocalDate.of(2024,10,1));
        s1.setTimeOfDay(LocalTime.of(18,30));
        s1.setCinema(c1);
        s1.setMovie(m1);
        screeningRepository.save(s1);

        Screening s2 = new Screening();
        s2.setDate(LocalDate.of(2024,10,1));
        s2.setTimeOfDay(LocalTime.of(21,30));
        s2.setCinema(c1);
        s2.setMovie(m1);
        screeningRepository.save(s2);

        Screening s3 = new Screening();
        s3.setDate(LocalDate.of(2024,10,1));
        s3.setTimeOfDay(LocalTime.of(21,30));
        s3.setCinema(c2);
        s3.setMovie(m2);
        screeningRepository.save(s3);

        Screening s4 = new Screening();
        s4.setDate(LocalDate.of(2024,10,1));
        s4.setTimeOfDay(LocalTime.of(18,30));
        s4.setCinema(c2);
        s4.setMovie(m2);
        screeningRepository.save(s4);

        /* TODO: Init seats with loops */

        // init bio1 (large theater) seats

        for (int rowCount = 1; rowCount <= 25 ; rowCount++) {
            for (int seatCount = 1; seatCount <= 16 ; seatCount++) {
                Seat seat = new Seat();
                seat.setCinema(c1); // bio 1
                seat.setPrice(100);
                seat.setRowNr(rowCount);
                seat.setSeatNr(seatCount);
                seatRepository.save(seat);
            }
        }

        // init bio2 (small theater) seats

        for (int rowCount = 1; rowCount <= 20 ; rowCount++) {
            for (int seatCount = 1; seatCount <= 12 ; seatCount++) {
                Seat seat = new Seat();
                seat.setCinema(c2); // bio 2
                seat.setPrice(100);
                seat.setRowNr(rowCount);
                seat.setSeatNr(seatCount);
                seatRepository.save(seat);
            }
        }

        // Create dummy seats only for initializing tickets…
        Seat seat1 = new Seat();
        seat1.setSeatId(1);

        Seat seat2 = new Seat();
        seat2.setSeatId(2);

        Ticket t1 = new Ticket();
        t1.setCustomerName("Niko");
        t1.setSeat(seat1);
        t1.setScreening(s1);
        ticketRepository.save(t1);

        Ticket t2 = new Ticket();
        t2.setCustomerName("Niko");
        t2.setSeat(seat2);
        t2.setScreening(s1);
        ticketRepository.save(t2);


    }

}
