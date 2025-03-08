package com.keyin.service;

import com.keyin.domain.City;
import com.keyin.repository.CityRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CityService {

    private final CityRepository cityRepository;

    public CityService(CityRepository cityRepository) {
        this.cityRepository = cityRepository;
    }

    public List<City> getAllCities() {
        return cityRepository.findAll();
    }

    public Optional<City> getCityById(Long id) {
        return cityRepository.findById(id);
    }

    public City addCity(City city) {
        return cityRepository.save(city);
    }

    public Optional<City> updateCity(Long id, City cityDetails) {
        return cityRepository.findById(id).map(city -> {
            city.setName(cityDetails.getName());
            city.setCountry(cityDetails.getCountry());
            return cityRepository.save(city);
        });
    }

    public boolean deleteCity(Long id) {
        if (cityRepository.existsById(id)) {
            cityRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
