package com.Example.SharathMotors.service;

import com.Example.SharathMotors.entity.CarDetails;
import com.Example.SharathMotors.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarService {
    @Autowired
    private CarRepository repo;

    public CarDetails addCar(CarDetails details) {
        return repo.save(details);
    }

    public List<CarDetails> getAllCars() {
        return repo.findAll();
    }

    public List<CarDetails> getCarsByavailabilityDate(String date) {
        return repo.findByAvailabilityDate(date);
    }


}
