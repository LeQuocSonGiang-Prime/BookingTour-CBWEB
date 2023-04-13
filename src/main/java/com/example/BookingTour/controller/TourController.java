package com.example.BookingTour.controller;

import com.example.BookingTour.model.Booking;
import com.example.BookingTour.model.ResponseObject;
import com.example.BookingTour.model.Tour;
import com.example.BookingTour.repositories.TourRepository;
import com.example.BookingTour.service.ITourService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/booking-tour/tour")
public class TourController {

    @Autowired
    private ITourService tourService;
    @Autowired
    private TourRepository tourRepository;

    @GetMapping("/")
    public ResponseEntity<ResponseObject> findAll() {
        return ResponseEntity.status(HttpStatus.OK).body(
                new ResponseObject("ok", "Query Tour Successfully", tourService.getAll())
        );
    }

    @GetMapping("/{id}")
    public  ResponseEntity<ResponseObject> findById(@PathVariable Long id){
        Optional<Tour> foundTour = tourService.getTourById(id);
        return foundTour.isPresent()?
                ResponseEntity.status(HttpStatus.OK).body(
                        new ResponseObject("ok", "Query Tour Successfully", tourService.getAll())) :
                ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                        new ResponseObject("failed", "Cannot find Tour by id = "+id,""));
    }



    @RequestMapping("/views")
    public ModelAndView homepage() {
        List<Tour> tours = tourRepository.findAll();
        ModelAndView modelAndView =  new ModelAndView("index");
        modelAndView.addObject("listTour", tours);
        return modelAndView;
    }

    @RequestMapping("/views/{id}")
    public ModelAndView detailTour(@PathVariable Long id) {
        Optional<Tour> tour = tourRepository.findById(id);
        ModelAndView modelAndView =  new ModelAndView("detail");
        modelAndView.addObject("tour", tour);
        return modelAndView;
    }



}
