package com.example.numtkinoxp.model;

import jakarta.persistence.*;

@Entity
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ticketId;
    private String customerName;

    @OneToOne
    @JoinColumn(name = "seatfk", referencedColumnName = "seatId")
    private Seat seat;

    @ManyToOne
    @JoinColumn(name = "screeningfk",referencedColumnName = "screeningID")
    private Screening screening;

    public Ticket() {
    }

    public Screening getScreening() {
        return screening;
    }

    public void setScreening(Screening screening) {
        this.screening = screening;
    }


    public Seat getSeat() {
        return seat;
    }

    public void setSeat(Seat seat) {
        this.seat = seat;
    }

    public int getTicketId() {
        return ticketId;
    }

    public void setTicketId(int ticketId) {
        this.ticketId = ticketId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }
}
