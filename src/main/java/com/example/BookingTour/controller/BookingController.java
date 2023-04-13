package com.example.BookingTour.controller;


import com.example.BookingTour.model.Booking;
import com.example.BookingTour.model.ResponseObject;
import com.example.BookingTour.model.Tour;
import com.example.BookingTour.service.IBookingService;
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
        modelAndView.addObject("tour", t);
        return modelAndView;
    }
    @PostMapping("/save-booking")
    public void saceBooking(@PathVariable Long id){
        String name =
    }
}
