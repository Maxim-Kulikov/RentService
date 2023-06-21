package com.example.rentservice.exception;

public class RoleNotFoundException extends Exception {
    public RoleNotFoundException(String roleName) {
        super("Role with name=" + roleName + " was not found");
    }

    public RoleNotFoundException(Integer id) {
        super("Role with id=" + id + " was not found");
    }
}
