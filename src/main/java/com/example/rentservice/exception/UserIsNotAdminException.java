package com.example.rentservice.exception;

public class UserIsNotAdminException extends Exception {
    public UserIsNotAdminException(Long id) {
        super("User with id=" + id.toString() + " is not admin");
    }
}
