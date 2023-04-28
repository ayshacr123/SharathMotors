package com.Example.SharathMotors.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;



@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CarDetails {
    @Id
    private Long car_id;
    private String carName;
    private String price;
    private String brand;
    private String colour;
    private int noOfSeat;
    private String availabilityDate;

}
