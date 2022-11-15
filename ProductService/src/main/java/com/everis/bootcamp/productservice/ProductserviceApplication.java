package com.everis.bootcamp.productservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
//@RestController
public class ProductserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProductserviceApplication.class, args);
	}

//	@RequestMapping("/product/msg")
//	public String home() {
//		return "Product Service Application is running";
//	}

}
