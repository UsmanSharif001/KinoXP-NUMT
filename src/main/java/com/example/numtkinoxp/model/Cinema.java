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
}
