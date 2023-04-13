package com.example.BookingTour.repositories;

import com.example.BookingTour.model.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingRepository extends JpaRepository<Booking, Long> {
}
