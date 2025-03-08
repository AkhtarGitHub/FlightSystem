package com.keyin.service;

import com.keyin.domain.Passenger;
import com.keyin.repository.PassengerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PassengerService {

    private final PassengerRepository passengerRepository;

    @Autowired
    public PassengerService(PassengerRepository passengerRepository) {
        this.passengerRepository = passengerRepository;
    }

    public List<Passenger> getAllPassengers() {
        return passengerRepository.findAll();
    }

    public Optional<Passenger> getPassengerById(Long id) {
        return passengerRepository.findById(id);
    }

    public Passenger savePassenger(Passenger passenger) {
        return passengerRepository.save(passenger);
    }

    public Optional<Passenger> updatePassenger(Long id, Passenger passengerDetails) {
        return passengerRepository.findById(id).map(existingPassenger -> {
            existingPassenger.setFirstName(passengerDetails.getFirstName());
            existingPassenger.setLastName(passengerDetails.getLastName());
            existingPassenger.setEmail(passengerDetails.getEmail());
            existingPassenger.setPhoneNumber(passengerDetails.getPhoneNumber());
            return passengerRepository.save(existingPassenger);
        });
    }

    public boolean deletePassenger(Long id) {
        if (passengerRepository.existsById(id)) {
            passengerRepository.deleteById(id);
            return true;
        }
        return false;
    }
}

