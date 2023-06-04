package com.dev.backend.controller;

import com.dev.backend.entity.Permission;
import com.dev.backend.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/permission")
public class PermissionController {
    @Autowired
    private PermissionService permissionService;
    @GetMapping("/")
    public List<Permission> searchAll(){
        return permissionService.searchAll();

    }
    @PostMapping("/")
    public Permission insert(@RequestBody Permission object){
        return permissionService.insert(object);

    }

    @PutMapping("/")
    public Permission update(@RequestBody Permission object){
        return permissionService.update(object);

    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> exclude (@PathVariable("id") Long id){
        permissionService.exclude(id);
        return ResponseEntity.ok().build();
    }
}
