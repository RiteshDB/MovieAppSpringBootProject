package com.upgrad.MovieApp.Entities;

import jakarta.persistence.*;
import org.springframework.stereotype.Component;

@Entity
public class Theater {

    public Theater(){

    }
    public Theater(int theaterId, String theaterName, int ticketPrice, City city) {
        this.theaterId = theaterId;
        this.theaterName = theaterName;
        this.ticketPrice = ticketPrice;
        this.city = city;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int theaterId;

    @Column(name = "theater_name", nullable = false)
    private String theaterName;

    @Column(nullable = false)
    private int ticketPrice;

    @ManyToOne
    @JoinColumn(name = "city", nullable = false)
    private City city;

    public int getTheaterId() {
        return theaterId;
    }

    public void setTheaterId(int theaterId) {
        this.theaterId = theaterId;
    }

    public String getTheaterName() {
        return theaterName;
    }

    public void setTheaterName(String theaterName) {
        this.theaterName = theaterName;
    }

    public int getTicketPrice() {
        return ticketPrice;
    }

    public void setTicketPrice(int ticketPrice) {
        this.ticketPrice = ticketPrice;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "Theater{" +
                "theaterId=" + theaterId +
                ", theaterName='" + theaterName + '\'' +
                ", ticketPrice=" + ticketPrice +
                ", city=" + city +
                '}';
    }
}
