package com.example.numtkinoxp.model;

import jakarta.persistence.*;

@Entity
public class Seat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int seatId;
    private int rowNr;
    private int seatNr;
    private int price;
    private boolean isReserved;

    @ManyToOne
    @JoinColumn(name = "cinemafk", referencedColumnName = "cinemaId")
    private Cinema cinema;

    public Seat() {
    }

    public int getSeatId() {
        return seatId;
    }

    public void setSeatId(int seatId) {
        this.seatId = seatId;
    }

    public int getRowNr() {
        return rowNr;
    }

    public void setRowNr(int rowNr) {
        this.rowNr = rowNr;
    }

    public int getSeatNr() {
        return seatNr;
    }

    public void setSeatNr(int seatNr) {
        this.seatNr = seatNr;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public boolean isReserved() {
        return isReserved;
    }

    public void setReserved(boolean reserved) {
        isReserved = reserved;
    }

    public Cinema getCinema(){
        return cinema;
    }

    public void setCinema(Cinema cinema){
        this.cinema = cinema;
    }
}
