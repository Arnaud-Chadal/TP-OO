package com.carrent.CarRent;

import com.carrent.CarRent.services.CarServiceImpl;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import com.carrent.CarRent.data.Car;

@SpringBootApplication
public class CarRentApplication {

	public static void main(String[] args) {
		SpringApplication.run(CarRentApplication.class, args);
	}

    @Bean
    public CommandLineRunner demo(CarServiceImpl carService) {
        return (args) -> {
            Car car = new Car("11AA22", "Ferrari", 1000);
            carService.addCar(car);
            car = new Car("22BB44", "Porshe", 2000);
            carService.addCar(car);
        };
    };
}