package com.example.BookingTour.controller;


import com.example.BookingTour.model.Booking;
import com.example.BookingTour.model.Customer;
import com.example.BookingTour.model.ResponseObject;
import com.example.BookingTour.model.Tour;
import com.example.BookingTour.service.IBookingService;
import com.example.BookingTour.service.ICustomerService;
import com.example.BookingTour.service.ITourService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@RestController
@RequestMapping("/booking-tour/booking")
public class BookingController {

    @Autowired
    private IBookingService bookingService;
    @Autowired
    private ITourService tourService;

    @Autowired
    private ICustomerService customerService;

    @PostMapping("/save")
    public ResponseEntity<ResponseObject> saveBooking(@RequestBody Booking booking) {
        Booking isSave = bookingService.saveBooking(booking);
        return isSave != null ?
                ResponseEntity.status(HttpStatus.OK).body(
                        new ResponseObject("ok", "Save booking Successfully", isSave)) :
                ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).body(
                        new ResponseObject("failed", "Cannot save booking ", ""));
    }

    @RequestMapping("/{id}")
    public ModelAndView bookingView(@PathVariable Long id) {
        ModelAndView modelAndView = new ModelAndView("Booking");
        Optional<Tour> t = tourService.getTourById(id);
        Booking booking = new Booking(); // create new instance of Booking
        modelAndView.addObject("booking", booking);
        modelAndView.addObject("tour", t);
        return modelAndView;
    }
    @PostMapping("/save-booking/{id}")
    public ModelAndView save(@ModelAttribute("booking") Booking booking, @PathVariable Long id){
        ModelAndView modelAndView = new ModelAndView("successfully");
        Optional<Tour> tour = tourService.getTourById(id);
        Customer customer = booking.getCustomer();
        System.out.println(customerService.saveCustomer(customer));;
        System.out.println(bookingService.saveBooking(booking));;
        return modelAndView;
    }
}
