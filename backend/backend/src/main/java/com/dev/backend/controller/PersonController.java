package com.dev.backend.controller;


import com.dev.backend.entity.Person;
import com.dev.backend.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/person")
public class PersonController {
    @Autowired
    private PersonService personService;
    @GetMapping("/")
    public List<Person> searchAll(){
        return personService.searchAll();

    }
    @PostMapping("/")
    public Person insert(@RequestBody Person object){
        return personService.insert(object);

    }

    @PutMapping("/")
    public Person update(@RequestBody Person object){
        return personService.update(object);

    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> exclude (@PathVariable("id") Long id){
        personService.exclude(id);
        return ResponseEntity.ok().build();
    }

}
