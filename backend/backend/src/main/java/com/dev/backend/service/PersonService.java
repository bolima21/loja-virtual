package com.dev.backend.service;

import com.dev.backend.entity.Person;
import com.dev.backend.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class PersonService {
    @Autowired
    private PersonRepository personRepository;

    public List<Person> searchAll(){
        return personRepository.findAll();
    }
    public Person insert(Person object){
        object.setCreationDate(new Date());
        Person newObject = personRepository.saveAndFlush(object);
        return newObject;
    }
    public Person update(Person object){
        object.setUpdateDate(new Date());
        return personRepository.saveAndFlush(object);

    }
    public void exclude(Long id){
        Person object = personRepository.findById(id).get();
        personRepository.delete(object);

    }
}
