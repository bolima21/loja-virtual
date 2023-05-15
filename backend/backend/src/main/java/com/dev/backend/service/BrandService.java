package com.dev.backend.service;

import com.dev.backend.entity.Brand;
import com.dev.backend.repository.BrandRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class BrandService {
    @Autowired
    private BrandRepository brandRepository;

    public List<Brand> searchAll(){
        return brandRepository.findAll();
    }
    public Brand insert(Brand brand){
        brand.setCreationDate(new Date());
        Brand newBrand = brandRepository.saveAndFlush(brand);
        return newBrand;
    }
    public Brand update(Brand brand){
        brand.setUpdateDate(new Date());
        return brandRepository.saveAndFlush(brand);

    }
    public void exclude(Long id){
        Brand brand = brandRepository.findById(id).get();
        brandRepository.delete(brand);

    }
}
