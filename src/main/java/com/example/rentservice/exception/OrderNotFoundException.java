package com.example.rentservice.exception;

public class OrderNotFoundException extends Exception {
    public OrderNotFoundException(Long id) {
        super("Order with id=" + id.toString() + " was not found");
    }
}
