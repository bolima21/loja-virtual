package com.dev.backend.service;

import com.dev.backend.entity.Permission;
import com.dev.backend.repository.PermissionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class PermissionService {
    @Autowired
    private PermissionRepository permissionRepository;

    public List<Permission> searchAll(){
        return permissionRepository.findAll();

    }

    public Permission insert(Permission object) {
        object.setCreationDate(new Date());
        Permission newObject = permissionRepository.saveAndFlush(object);
        return newObject;
    }
    public Permission update(Permission object) {
        object.setCreationDate(new Date());
        return permissionRepository.saveAndFlush(object);
    }
    public void exclude(Long id) {
        Permission object = permissionRepository.findById(id).get();
        permissionRepository.delete(object);
    }

}
