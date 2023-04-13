package com.example.BookingTour.repositories;

import com.example.BookingTour.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer,Long> {


}
