package com.dev.backend.controller;

import com.dev.backend.entity.City;
import com.dev.backend.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/city")
public class CityController {
    @Autowired
    private CityService cityService;
    @GetMapping("/")
    public List<City> searchAll(){
        return cityService.searchAll();

    }
    @PostMapping("/")
    public City insert(@RequestBody City object){
        return cityService.insert(object);

    }

    @PutMapping("/")
    public City update(@RequestBody City object){
        return cityService.update(object);

    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> exclude (@PathVariable("id") Long id){
        cityService.exclude(id);
        return ResponseEntity.ok().build();
    }
}
