package com.dev.backend.controller;

import com.dev.backend.entity.Brand;
import com.dev.backend.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/brand")
public class BrandController {
    @Autowired
    private BrandService brandService;
    @GetMapping("/")
    public List<Brand> searchAll(){
        return brandService.searchAll();

    }
    @PostMapping("/")
    public Brand insert(@RequestBody Brand brand){
        return brandService.insert(brand);

    }

    @PutMapping("/")
    public Brand update(@RequestBody Brand brand){
        return brandService.update(brand);

    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> exclude (@PathVariable("id") Long id){
        brandService.exclude(id);
        return ResponseEntity.ok().build();
    }
}
