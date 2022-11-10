package com.everis.bootcamp.employeeservice;

public class EmployeeNotFoundException extends RuntimeException {

    public EmployeeNotFoundException(Long id) {
        super("No se pudo encontrar el usuario con Id: " + id);
    }
}
