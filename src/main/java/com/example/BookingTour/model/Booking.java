package com.example.BookingTour.model;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "booking")
@Setter
@Getter
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;
    @ManyToOne
    @JoinColumn(name = "tour_id")
    private Tour tour;
    private String departureDate;
    private int noAdults;
    private int noChildren;


    @Override
    public String toString() {
        return "Booking{" +
                "id=" + id +
                ", customer=" + customer +
                ", tour=" + tour +
                ", departureDate=" + departureDate +
                ", noAdults=" + noAdults +
                ", noChildren=" + noChildren +
                '}';
    }
}
