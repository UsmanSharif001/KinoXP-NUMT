package com.example.numtkinoxp.model;

import com.example.numtkinoxp.repository.MovieRepository;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Screening {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int screeningID;
    private LocalDate date;
    private LocalTime timeOfDay;

    @ManyToOne
    @JoinColumn(name = "moviefk", referencedColumnName = "movieID")
    private Movie movie;

    @ManyToOne
    @JoinColumn(name = "cinemafk",referencedColumnName = "cinemaId")
    private Cinema cinema;

    @OneToMany(mappedBy = "screening")
    @JsonBackReference
    Set<Ticket> tickets = new HashSet<>();

    public Screening() {
    }

    public int getScreeningID() {
        return screeningID;
    }

    public void setScreeningID(int screeningID) {
        this.screeningID = screeningID;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public LocalTime getTimeOfDay() {
        return timeOfDay;
    }

    public void setTimeOfDay(LocalTime timeOfDay) {
        this.timeOfDay = timeOfDay;
    }

    public Movie getMovie(){
        return movie;
    }

    public void setMovie(Movie movie){
        this.movie = movie;
    }

    public Cinema getCinema(){
        return cinema;
    }

    public void setCinema(Cinema cinema){
        this.cinema = cinema;
    }
}
