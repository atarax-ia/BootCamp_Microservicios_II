package com.everis.bootcamp.priceservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class PriceserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(PriceserviceApplication.class, args);
	}

	@RequestMapping("/")
	public String home() {
		return "Hello, world! \n PriceeServiceApplication";
	}

}
