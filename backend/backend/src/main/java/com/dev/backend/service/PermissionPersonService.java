package com.dev.backend.service;

import com.dev.backend.entity.Permission;
import com.dev.backend.entity.PermissionPerson;
import com.dev.backend.entity.Person;
import com.dev.backend.repository.PermissionPersonRepository;
import com.dev.backend.repository.PermissionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;


@Service
public class PermissionPersonService {
    @Autowired
    private PermissionPersonRepository permissionPersonRepository;

    @Autowired
    private PermissionRepository permissionRepository;

    public void linkPersonPermissionClient(Person person){
        List<Permission> listPermission = permissionRepository.findByName("client");
        if (listPermission.size()>0){
            PermissionPerson permissionPerson = new PermissionPerson();
            permissionPerson.setPerson(person);
            permissionPerson.setPermission(listPermission.get(0));
            permissionPerson.setCreationDate(new Date());
            permissionPersonRepository.saveAndFlush(permissionPerson);
        }


    }
}

