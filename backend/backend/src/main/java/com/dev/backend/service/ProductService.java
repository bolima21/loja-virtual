package com.dev.backend.service;


import com.dev.backend.entity.Product;
import com.dev.backend.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public List<Product> searchAll(){
        return productRepository.findAll();
    }
    public Product insert(Product object){
        object.setCreationDate(new Date());
        Product newObject = productRepository.saveAndFlush(object);
        return newObject;
    }
    public Product update(Product object){
        object.setUpdateDate(new Date());
        return productRepository.saveAndFlush(object);

    }
    public void exclude(Long id){
        Product object = productRepository.findById(id).get();
        productRepository.delete(object);

    }
}
