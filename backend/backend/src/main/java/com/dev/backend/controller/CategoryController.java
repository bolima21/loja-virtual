package com.dev.backend.controller;

import com.dev.backend.entity.Category;
import com.dev.backend.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/category")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;
    @GetMapping("/")
    public List<Category> searchAll(){
        return categoryService.searchAll();

    }
    @PostMapping("/")
    public Category insert(@RequestBody Category category){
        return categoryService.insert(category);

    }

    @PutMapping("/")
    public Category update(@RequestBody Category category){
        return categoryService.update(category);

    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> exclude (@PathVariable("id") Long id){
        categoryService.exclude(id);
        return ResponseEntity.ok().build();
    }
}
