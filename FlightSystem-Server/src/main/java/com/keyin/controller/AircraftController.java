package com.keyin.controller;

import com.keyin.domain.Aircraft;
import com.keyin.service.AircraftService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/aircrafts")
public class AircraftController {

    private final AircraftService aircraftService;

    @Autowired
    public AircraftController(AircraftService aircraftService) {
        this.aircraftService = aircraftService;
    }

    @GetMapping
    public ResponseEntity<List<Aircraft>> getAllAircrafts() {
        return ResponseEntity.ok(aircraftService.getAllAircrafts());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Aircraft> getAircraftById(@PathVariable Long id) {
        Optional<Aircraft> aircraft = aircraftService.getAircraftById(id);
        return aircraft.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Aircraft> addAircraft(@RequestBody Aircraft aircraft) {
        return ResponseEntity.ok(aircraftService.saveAircraft(aircraft));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Aircraft> updateAircraft(@PathVariable Long id, @RequestBody Aircraft aircraftDetails) {
        Optional<Aircraft> updatedAircraft = aircraftService.updateAircraft(id, aircraftDetails);
        return updatedAircraft.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAircraft(@PathVariable Long id) {
        boolean deleted = aircraftService.deleteAircraft(id);
        return deleted ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }
}

