package com.keyin.client;

import com.keyin.domain.Airport;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Service
public class RESTClient {

    private final RestTemplate restTemplate;
    private final String BASE_URL = "http://localhost:8080/api/airports"; // Replace with actual API URL

    // Constructor with Dependency Injection
    public RESTClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    // Default constructor for testing (if needed)
    public RESTClient() {
        this.restTemplate = new RestTemplate();
    }

    // Fetch all airports from the API
    public List<Airport> getAllAirports() {
        ResponseEntity<Airport[]> response = restTemplate.getForEntity(BASE_URL, Airport[].class);

        if (response.getBody() != null) {
            return Arrays.asList(response.getBody());
        } else {
            return List.of(); // Return an empty list if no data
        }
    }
}
