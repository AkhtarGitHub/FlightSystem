package com.keyin.client;

import com.keyin.domain.Airport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class FlightSystemClient implements CommandLineRunner {

    private final RESTClient restClient;

    @Autowired
    public FlightSystemClient(RESTClient restClient) {
        this.restClient = restClient;
    }

    @Override
    public void run(String... args) {
        System.out.println("Fetching all airports...");

        List<Airport> airports = restClient.getAllAirports();

        if (airports.isEmpty()) {
            System.out.println("No airports found.");
        } else {
            System.out.println("Airports found:");
            airports.forEach(airport -> System.out.println(airport.getName() + " (" + airport.getCode() + ")"));
        }
    }
}
