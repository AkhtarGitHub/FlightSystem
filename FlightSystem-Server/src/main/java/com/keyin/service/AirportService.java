package com.keyin.service;

import com.keyin.domain.Airport;
import com.keyin.repository.AirportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AirportService {

    private final AirportRepository airportRepository;

    @Autowired
    public AirportService(AirportRepository airportRepository) {
        this.airportRepository = airportRepository;
    }

    // Fetch all airports
    public List<Airport> getAllAirports() {
        return airportRepository.findAll();
    }

    // Fetch an airport by ID
    public Optional<Airport> getAirportById(Long id) {
        return airportRepository.findById(id);
    }

    // Add a new airport
    public Airport saveAirport(Airport airport) {
        return airportRepository.save(airport);
    }

    // Update an existing airport
    public Airport updateAirport(Long id, Airport updatedAirport) {
        return airportRepository.findById(id)
                .map(airport -> {
                    airport.setName(updatedAirport.getName());
                    airport.setCode(updatedAirport.getCode());
                    return airportRepository.save(airport);
                })
                .orElseThrow(() -> new RuntimeException("Airport not found"));
    }

    // Delete an airport
    public void deleteAirport(Long id) {
        airportRepository.deleteById(id);
    }
}

