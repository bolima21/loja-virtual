package com.dev.backend.service;

import com.dev.backend.dto.PersonClientRequestDTO;
import com.dev.backend.entity.Person;
import com.dev.backend.repository.PermissionRepository;
import com.dev.backend.repository.PersonClientRepository;
import com.dev.backend.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class PersonClientService {
    @Autowired
    private PersonClientRepository personRepository;

    @Autowired
    private PermissionPersonService permissionPersonService;
    public Person registrate(PersonClientRequestDTO personClientRequestDTO){
        Person person = new PersonClientRequestDTO().convert(personClientRequestDTO);

        person.setCreationDate(new Date());
        Person newObject = personRepository.saveAndFlush(person);
        permissionPersonService.linkPersonPermissionClient(newObject );
        return newObject;
    }

}

