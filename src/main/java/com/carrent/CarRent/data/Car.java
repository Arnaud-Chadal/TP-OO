package com.carrent.CarRent.data;
import jakarta.persistence.*;

@Entity
public class Car
{
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "car_seq")
    @SequenceGenerator(name = "car_seq", sequenceName = "car_id_seq", allocationSize = 1)
    private Long id;

    private String plateNumber;
    private String brand;
    private int price;

    public Car()
    {
        plateNumber = "undefined";
        brand = "undefined";
        price = 0;
    }

    public Car(String plateNumber, String brand, int price)
    {
        this.plateNumber = plateNumber;
        this.brand = brand;
        this.price = price;
    }

    public void setPlateNumber(String plateNumber) {this.plateNumber = plateNumber;}
    public void setBrand(String brand) {this.brand = brand;}
    public void setPrice(int price) {this.price = price;}

    public String getPlateNumber() {return plateNumber;}
    public String getBrand() {return brand;}
    public int getPrice() {return price;}
}
