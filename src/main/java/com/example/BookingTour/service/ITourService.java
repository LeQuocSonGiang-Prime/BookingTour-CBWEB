package com.example.BookingTour.service;

import com.example.BookingTour.model.Tour;

import java.util.List;
import java.util.Optional;

public interface ITourService {

    List<Tour> getAll();
    Optional<Tour> getTourById(Long id);

}
