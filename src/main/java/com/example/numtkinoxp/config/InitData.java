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
        c1.setRowCount(25);
        c1.setSeatCount(16);
        cinemaRepository.save(c1);

        // Bio 2 / small theater

        Cinema c2 = new Cinema();
        c2.setName("Bio 2");
        c2.setRowCount(20);
        c2.setSeatCount(12);
        cinemaRepository.save(c2);

        Screening s1 = new Screening();
        s1.setDate(LocalDate.of(2024, 10, 1));
        s1.setTimeOfDay(LocalTime.of(18, 30));
        s1.setCinema(c1);
        s1.setMovie(m1);
        screeningRepository.save(s1);

        Screening s2 = new Screening();
        s2.setDate(LocalDate.of(2024, 10, 1));
        s2.setTimeOfDay(LocalTime.of(21, 30));
        s2.setCinema(c1);
        s2.setMovie(m1);
        screeningRepository.save(s2);

        Screening s3 = new Screening();
        s3.setDate(LocalDate.of(2024, 10, 1));
        s3.setTimeOfDay(LocalTime.of(21, 30));
        s3.setCinema(c2);
        s3.setMovie(m2);
        screeningRepository.save(s3);

        Screening s4 = new Screening();
        s4.setDate(LocalDate.of(2024, 10, 1));
        s4.setTimeOfDay(LocalTime.of(18, 30));
        s4.setCinema(c2);
        s4.setMovie(m2);
        screeningRepository.save(s4);

        Screening s5 = new Screening();
        s5.setDate(LocalDate.of(2024, 10, 10));
        s5.setTimeOfDay(LocalTime.of(21, 30));
        s5.setCinema(c2);
        s5.setMovie(m3);
        screeningRepository.save(s5);

        /* TODO: Init seats with loops */

        // init bio1 (large theater) seats

        for (int rowCount = 1; rowCount <= c1.getRowCount(); rowCount++) {
            for (int seatCount = 1; seatCount <= c1.getSeatCount(); seatCount++) {
                Seat seat = new Seat();
                seat.setCinema(c1); // bio 1
                if (rowCount <= 20) { // back seats more expensive
                    seat.setPrice(100);
                } else {
                    seat.setPrice(120);
                }
                seat.setRowNr(rowCount);
                seat.setSeatNr(seatCount);
                seatRepository.save(seat);
            }
        }

        // init bio2 (small theater) seats

        for (int rowCount = 1; rowCount <= c2.getRowCount(); rowCount++) {
            for (int seatCount = 1; seatCount <= c2.getSeatCount(); seatCount++) {
                Seat seat = new Seat();
                seat.setCinema(c2); // bio 2
                if (rowCount <= 2) { // front seats cheaper
                    seat.setPrice(70);
                } else {
                    seat.setPrice(100);
                }
                seat.setRowNr(rowCount);
                seat.setSeatNr(seatCount);
                seatRepository.save(seat);
            }
        }

        // Create dummy seats only for initializing tickets…
        LocalDate startDate = LocalDate.of(2024, 10, 8); // Starting from October 1st, 2024
        LocalTime[] times = {LocalTime.of(18, 30), LocalTime.of(21, 30)}; // 2 time slots per day

        for (int i = 0; i < 7; i++) {  // Loop for 7 days
            LocalDate currentDate = startDate.plusDays(i); // Increment the date each time

            // Create screenings for movie 1 in cinema 1
            for (LocalTime time : times) {
                Screening screening = new Screening();
                screening.setDate(currentDate);
                screening.setTimeOfDay(time);
                screening.setCinema(c1);
                screening.setMovie(m1);
                screeningRepository.save(screening);
            }

            // Create screenings for movie 2 in cinema 2
            for (LocalTime time : times) {
                Screening screening = new Screening();
                screening.setDate(currentDate);
                screening.setTimeOfDay(time);
                screening.setCinema(c2);
                screening.setMovie(m2);
                screeningRepository.save(screening);
            }
        }

        Seat seat1 = new Seat();
        seat1.setSeatId(344);

        Seat seat2 = new Seat();
        seat2.setSeatId(345);

        Seat seat3 = new Seat();
        seat3.setSeatId(561);

        Seat seat4 = new Seat();
        seat4.setSeatId(562);

        Seat seat5 = new Seat();
        seat5.setSeatId(167);

        Seat seat6 = new Seat();
        seat6.setSeatId(168);

        Seat seat7 = new Seat();
        seat7.setSeatId(166);

        Seat seat8 = new Seat();
        seat8.setSeatId(181);

        Seat seat9 = new Seat();
        seat9.setSeatId(182);

        Seat seat10 = new Seat();
        seat10.setSeatId(267);

        Seat seat11 = new Seat();
        seat11.setSeatId(268);

        Seat seat12 = new Seat();
        seat12.setSeatId(298);

        Seat seat13 = new Seat();
        seat13.setSeatId(299);

        Seat seat14 = new Seat();
        seat14.setSeatId(297);

        Seat seat15 = new Seat();
        seat15.setSeatId(300);

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

        Ticket t3 = new Ticket();
        t3.setCustomerName("Joko");
        t3.setSeat(seat1);
        t3.setScreening(s2);
        ticketRepository.save(t3);

        Ticket t4 = new Ticket();
        t4.setCustomerName("Gumbi");
        t4.setSeat(seat3);
        t4.setScreening(s3);
        ticketRepository.save(t4);

        Ticket t5 = new Ticket();
        t5.setCustomerName("Gumbi");
        t5.setSeat(seat4);
        t5.setScreening(s3);
        ticketRepository.save(t5);

        Ticket t6 = new Ticket();
        t6.setCustomerName("Thea");
        t6.setSeat(seat5);
        t6.setScreening(s1);
        ticketRepository.save(t6);

        Ticket t7 = new Ticket();
        t7.setCustomerName("Thea");
        t7.setSeat(seat6);
        t7.setScreening(s1);
        ticketRepository.save(t7);

        Ticket t8 = new Ticket();
        t8.setCustomerName("Thea");
        t8.setSeat(seat7);
        t8.setScreening(s1);
        ticketRepository.save(t8);

        Ticket t9 = new Ticket();
        t9.setCustomerName("Marie");
        t9.setSeat(seat8);
        t9.setScreening(s1);
        ticketRepository.save(t9);

        Ticket t10 = new Ticket();
        t10.setCustomerName("Marie");
        t10.setSeat(seat9);
        t10.setScreening(s1);
        ticketRepository.save(t10);

        Ticket t11 = new Ticket();
        t11.setCustomerName("Usman");
        t11.setSeat(seat10);
        t11.setScreening(s1);
        ticketRepository.save(t11);

        Ticket t12 = new Ticket();
        t12.setCustomerName("Usman");
        t12.setSeat(seat11);
        t12.setScreening(s1);
        ticketRepository.save(t12);

        Ticket t13 = new Ticket();
        t13.setCustomerName("Usman");
        t13.setSeat(seat12);
        t13.setScreening(s1);
        ticketRepository.save(t13);

        Ticket t14 = new Ticket();
        t14.setCustomerName("John");
        t14.setSeat(seat13);
        t14.setScreening(s1);
        ticketRepository.save(t14);

        Ticket t15 = new Ticket();
        t15.setCustomerName("John");
        t15.setSeat(seat14);
        t15.setScreening(s1);
        ticketRepository.save(t15);

        Ticket t16 = new Ticket();
        t16.setCustomerName("John");
        t16.setSeat(seat15);
        t16.setScreening(s1);
        ticketRepository.save(t16);
    }
}
