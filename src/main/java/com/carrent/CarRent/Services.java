package com.carrent.CarRent;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.HashMap;
import java.util.NoSuchElementException;

@Service
public class Services
{
    private HashMap<String, Car> cars;
    private HashMap<String, Car> rentedCars;

    public Services()
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

    public HashMap<String, Car> displayCars() {System.out.println("zrzr"); return cars;}
    public HashMap<String, Car> displayRentedCars()
    {
        return rentedCars;
    }

    public String rentCar(String plateNumber)
    {
        Car selectedCar = cars.get(plateNumber);
        if (selectedCar == null)
        {
            throw new NoSuchElementException("Clé introuvable : " + plateNumber);
        }
        rentedCars.put(plateNumber, selectedCar);
        cars.remove(plateNumber);
        return "rented !";
    }

    public String recoverCar(String plateNumber)
    {
        Car selectedCar = rentedCars.get(plateNumber);
        if (selectedCar == null)
        {
            throw new NoSuchElementException("Clé introuvable : " + plateNumber);
        }
        cars.put(plateNumber, selectedCar);
        rentedCars.remove(plateNumber);
        return "recovered !";
    }
}
