package com.keyin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.keyin")
public class FlightSystemApplication {
    public static void main(String[] args) {
        SpringApplication.run(FlightSystemApplication.class, args);
    }
}

