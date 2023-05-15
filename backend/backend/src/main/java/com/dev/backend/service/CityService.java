package com.dev.backend.service;

import com.dev.backend.entity.City;
import com.dev.backend.repository.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class CityService {
    @Autowired
    private CityRepository cityRepository;

    public List<City> searchAll(){
        return cityRepository.findAll();

    }

    public City insert(City city) {
        city.setCreationDate(new Date());
        City newCity = cityRepository.saveAndFlush(city);
        return newCity;
    }
    public City update(City object) {
        object.setCreationDate(new Date());
        return cityRepository.saveAndFlush(object);
    }
    public void exclude(Long id) {
        City object = cityRepository.findById(id).get();
        cityRepository.delete(object);
    }
}
