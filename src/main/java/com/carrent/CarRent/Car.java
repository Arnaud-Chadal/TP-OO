package com.carrent.CarRent;

@jakarta.persistence.Entity
public class Car
{
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

    @jakarta.persistence.Id
    public String getPlateNumber() {return plateNumber;}
    public String getBrand() {return brand;}
    public int getPrice() {return price;}
}
