package com.carrent.CarRent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.NoSuchElementException;

@RestController
public class RentalService
{

    @Autowired
    private Services services;

    public RentalService(){}

    @GetMapping("/cars")
    public HashMap<String, Car> displayCars() {return services.displayCars();}

    @GetMapping("/rented")
    public HashMap<String, Car> displayRentedCars()
    {
        return services.displayRentedCars();
    }

    @GetMapping("/cars/rent{plateNumber}")
    public String rentCar(@PathVariable("plateNumber") String plateNumber) {return services.rentCar(plateNumber);}

    @GetMapping("/rented/recover{plateNumber}")
    public String recoverCar(@PathVariable("plateNumber") String plateNumber) {return services.recoverCar(plateNumber);}

    //@GetMapping("/error")
    //public String displayError() {return "Requested car doesn't exists :(";}
}