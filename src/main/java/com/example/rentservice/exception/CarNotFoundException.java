package com.example.rentservice.exception;

public class CarNotFoundException extends Exception {
    public CarNotFoundException(Integer id) {
        super("Car with id=" + id.toString() + " was not found");
    }
}
