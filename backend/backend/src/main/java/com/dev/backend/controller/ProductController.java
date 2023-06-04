package com.dev.backend.controller;

import com.dev.backend.entity.Product;
import com.dev.backend.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/product")
public class ProductController {
    @Autowired
    private ProductService productService;
    @GetMapping("/")
    public List<Product> searchAll(){
        return productService.searchAll();

    }
    @PostMapping("/")
    public Product insert(@RequestBody Product object){
        return productService.insert(object);

    }

    @PutMapping("/")
    public Product update(@RequestBody Product object){
        return productService.update(object);

    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> exclude (@PathVariable("id") Long id){
        productService.exclude(id);
        return ResponseEntity.ok().build();
    }
}
