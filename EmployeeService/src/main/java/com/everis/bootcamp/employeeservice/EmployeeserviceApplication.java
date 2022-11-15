package com.everis.bootcamp.employeeservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class EmployeeserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmployeeserviceApplication.class, args);
	}

	@RequestMapping("/employee/msg")
	public String home() {
		return "Employee Service Application is running";
	}

}
