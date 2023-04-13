package com.example.BookingTour.service.implement;

import com.example.BookingTour.model.Tour;
import com.example.BookingTour.repositories.TourRepository;
import com.example.BookingTour.service.ITourService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class TourServiceImp implements ITourService {
    @Autowired
    private TourRepository repository;
    @Override
    public List<Tour> getAll() {
        return repository.findAll();
    }

    @Override
    public Optional<Tour> getTourById(Long id) {
        return repository.findById(id);
    }
}
