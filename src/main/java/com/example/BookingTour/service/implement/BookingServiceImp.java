package com.example.BookingTour.service.implement;

import com.example.BookingTour.model.Booking;
import com.example.BookingTour.repositories.BookingRepository;
import com.example.BookingTour.service.IBookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookingServiceImp implements IBookingService {
    @Autowired
    private BookingRepository repository;

    @Override
    public Booking saveBooking(Booking booking) {
        return repository.save(booking);
    }
}
