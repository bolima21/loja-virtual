package com.dev.backend.controller;


import com.dev.backend.entity.ProductImages;
import com.dev.backend.service.ProductImagesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/api/productImages")
public class ProductImagesController {
    @Autowired
    private ProductImagesService productImagesService;
    @GetMapping("/")
    public List<ProductImages> searchAll(){
        return productImagesService.searchAll();

    }
    @PostMapping("/")
    public ProductImages insert(@RequestParam("idProduct") Long idProduct, @RequestParam("file") MultipartFile file){
        return productImagesService.insert(idProduct, file);

    }

    @PutMapping("/")
    public ProductImages update(@RequestBody ProductImages object){
        return productImagesService.update(object);

    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> exclude (@PathVariable("id") Long id){
        productImagesService.exclude(id);
        return ResponseEntity.ok().build();
    }
}
