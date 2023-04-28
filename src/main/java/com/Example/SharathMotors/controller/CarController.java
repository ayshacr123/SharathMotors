package com.Example.SharathMotors.controller;

import com.Example.SharathMotors.entity.CarDetails;
import com.Example.SharathMotors.service.CarService;
//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sharathcars")
public class CarController {
    @Autowired
    private CarService service;

    @PostMapping
    public CarDetails addCars(@RequestBody CarDetails details){
        return service.addCar(details);
    }

    @GetMapping("/cars")
    public List<CarDetails> getAllCar(){
        return service.getAllCars();
    }

    @GetMapping("/cars/{availabilityDate}")
    public List<CarDetails> getCarsByDates(@PathVariable("availabilityDate") String date){
        return service.getCarsByavailabilityDate(date);
    }


}
