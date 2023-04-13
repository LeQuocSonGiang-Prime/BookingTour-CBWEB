package com.example.BookingTour.service.implement;

import com.example.BookingTour.model.Customer;
import com.example.BookingTour.repositories.CustomerRepository;
import com.example.BookingTour.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImp implements ICustomerService {

    @Autowired
    private CustomerRepository repository;

    @Override
    public Customer saveCustomer(Customer c) {
        return repository.save(c);
    }
}
