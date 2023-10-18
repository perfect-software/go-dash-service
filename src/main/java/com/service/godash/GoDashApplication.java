package com.service.godash;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.CrossOrigin;

@SpringBootApplication
@CrossOrigin(origins="http://localhost:5173")
public class GoDashApplication {

	public static void main(String[] args) {
		SpringApplication.run(GoDashApplication.class, args);
	}

}
