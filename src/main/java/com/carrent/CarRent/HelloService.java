package com.carrent.CarRent;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
public class HelloService
{
    private HashMap<String, Car> cars;
    private HashMap<String, Car> rentedCars;
    private int test = 0;


    public HelloService()
    {
        cars = new HashMap<String, Car>();
        rentedCars = new HashMap<String, Car>();
        Car car1 = new Car("AA22BB", "Ford", 20);
        Car car2 = new Car("CC55BB", "Ford", 15);
        Car car3 = new Car("YY99BB", "Ford", 40);
        cars.put(car1.getPlateNumber(), car1);
        cars.put(car2.getPlateNumber(), car2);
        cars.put(car3.getPlateNumber(), car3);
    }

    @GetMapping("/cars")
    public HashMap<String, Car> displayCars()
    {
        return cars;
    }

    @GetMapping("/rented")
    public HashMap<String, Car> displayRentedCars()
    {
        return rentedCars;
    }

    @GetMapping("/cars/rent{plateNumber}")
    public String rentCar(@PathVariable("plateNumber") String plateNumber) throws Exception
    {
        Car selectedCar = cars.get(plateNumber);
        if (selectedCar == null) {return "Requested car doesn't exists :(";}
        rentedCars.put(plateNumber, selectedCar);
        cars.remove(plateNumber);
        return "rented :)";
    }

    @GetMapping("/cars/recover{plateNumber}")
    public String recoverCar(@PathVariable("plateNumber") String plateNumber)
    {
        Car selectedCar = rentedCars.get(plateNumber);
        if (selectedCar == null) {return "Requested car doesn't exists :(";}
        cars.put(plateNumber, selectedCar);
        rentedCars.remove(plateNumber);
        return "recovered :)";
    }
} 