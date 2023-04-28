package com.Example.SharathMotors.repository;

import com.Example.SharathMotors.entity.CarDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarRepository extends JpaRepository<CarDetails, Long> {
    List<CarDetails> findByAvailabilityDate(String date);
}
