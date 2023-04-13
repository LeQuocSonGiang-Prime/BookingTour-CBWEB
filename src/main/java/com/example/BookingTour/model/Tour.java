package com.example.BookingTour.model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "tour")
@Setter
@Getter
@JsonIgnoreProperties("bookings")
public class Tour implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String description;
    private String days;
    private String transportation;
    private String departureSchedule;
    private Double price;

    @OneToMany(mappedBy = "tour", cascade = CascadeType.ALL, orphanRemoval = true)

    private List<Booking> bookings = new ArrayList<>();


    public Tour() {
    }

    public Tour(String description, String days, String transportation, String departureSchedule, Double price) {
        this.description = description;
        this.days = days;
        this.transportation = transportation;
        this.departureSchedule = departureSchedule;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Tour{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", days='" + days + '\'' +
                ", transportation='" + transportation + '\'' +
                ", departureSchedule='" + departureSchedule + '\'' +
                ", price=" + price +
                '}';
    }
}
