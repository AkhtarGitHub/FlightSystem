package com.keyin.service;

import com.keyin.domain.Aircraft;
import com.keyin.repository.AircraftRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AircraftService {

    private final AircraftRepository aircraftRepository;

    @Autowired
    public AircraftService(AircraftRepository aircraftRepository) {
        this.aircraftRepository = aircraftRepository;
    }

    public List<Aircraft> getAllAircrafts() {
        return aircraftRepository.findAll();
    }

    public Optional<Aircraft> getAircraftById(Long id) {
        return aircraftRepository.findById(id);
    }

    public Aircraft saveAircraft(Aircraft aircraft) {
        return aircraftRepository.save(aircraft);
    }

    public Optional<Aircraft> updateAircraft(Long id, Aircraft aircraftDetails) {
        return aircraftRepository.findById(id).map(existingAircraft -> {
            existingAircraft.setModel(aircraftDetails.getModel());
            existingAircraft.setManufacturer(aircraftDetails.getManufacturer());
            existingAircraft.setCapacity(aircraftDetails.getCapacity());
            return aircraftRepository.save(existingAircraft);
        });
    }

    public boolean deleteAircraft(Long id) {
        if (aircraftRepository.existsById(id)) {
            aircraftRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
