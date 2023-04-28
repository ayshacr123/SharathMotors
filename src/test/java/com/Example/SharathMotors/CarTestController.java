package com.Example.SharathMotors;

import com.Example.SharathMotors.controller.CarController;
import com.Example.SharathMotors.entity.CarDetails;
import com.Example.SharathMotors.service.CarService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDate;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;


@WebMvcTest(CarController.class)
public class CarTestController {

    @Autowired
    private MockMvc mockmvc;

    @MockBean
    private CarService service;

    private CarDetails car;

    @BeforeEach
    void setup() {

        car = new CarDetails(1L, "City", "1000", "HONDA", "White", 5, "2023-04-03");
    }

    @Test
    void testGetAllCars() throws Exception {

        final List<CarDetails> car = List.of(new CarDetails(1L, "City", "1000", "HONDA", "White", 5, "2023-04-03"));
        when(service.getAllCars()).thenReturn(car);

        // Run the test
        final MockHttpServletResponse response = mockmvc.perform(get("/sharathcars/cars")
                        .accept(MediaType.APPLICATION_JSON))
                .andReturn().getResponse();

        // Verify the results
        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
//        assertThat(response.getContentAsString()).isEqualTo("expectedResponse");
    }

    @Test
    void testGetCarsByDate() throws Exception {
        // Setup
        // Configure StudentService.getStudentByName(...).
        final List<CarDetails> car = List.of(new CarDetails(1L, "City", "1000", "HONDA", "White", 5, "2023-04-03"));
        when(service.getCarsByavailabilityDate("date")).thenReturn(car);

        // Run the test
        final MockHttpServletResponse response = mockmvc.perform(get("/sharathcars/cars/{date}", "date")
                        .accept(MediaType.APPLICATION_JSON))
                .andReturn().getResponse();

        // Verify the results
        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
    }
}

