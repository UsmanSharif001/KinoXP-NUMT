package com.example.numtkinoxp.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
public class Cinema {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int cinemaId;
    private String name;
    private int rowCount;
    private int seatCount;

    @OneToMany(mappedBy = "cinema")
    @JsonBackReference("cinema-screenings")
    private Set<Screening> screenings = new HashSet<>();

    @OneToMany(mappedBy = "cinema")
    @JsonBackReference("cinema-seats")
    private Set<Seat> seats = new HashSet<>();

    public int getCinemaId() {
        return cinemaId;
    }

    public void setCinemaId(int cinemaId) {
        this.cinemaId = cinemaId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRowCount() {
        return rowCount;
    }

    public void setRowCount(int rowCount) {
        this.rowCount = rowCount;
    }

    public int getSeatCount() {
        return seatCount;
    }

    public void setSeatCount(int seatCount) {
        this.seatCount = seatCount;
    }

    public Set<Seat> getSeats() {
        return seats;
    }
}
