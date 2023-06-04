package com.dev.backend.service;

import com.dev.backend.entity.Product;
import com.dev.backend.repository.ProductRepository;
import com.dev.backend.entity.ProductImages;
import com.dev.backend.repository.ProductImagesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;
import java.util.List;

@Service
public class ProductImagesService {
    @Autowired
    private ProductImagesRepository productImagesRepository;

    @Autowired
    private ProductRepository productRepository;

    public List<ProductImages> searchAll(){
        return productImagesRepository.findAll();

    }

    public ProductImages insert(Long idProduct, MultipartFile file) {
        Product product = productRepository.findById(idProduct).get();
        ProductImages object = new ProductImages();

        try {
            if(!file.isEmpty()) {
                byte[] bytes = file.getBytes();
                String imageName = String.valueOf(product.getId()) + file.getOriginalFilename();
                Path pathWay = Paths.get("C:/Users/brenn/OneDrive/Documentos/images-lojaVirtual/" + imageName);
                Files.write(pathWay, bytes);
                object.setName(imageName);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        object.setProduct(product);
        object.setCreationDate(new Date());
        object = productImagesRepository.saveAndFlush(object);
        return object;
    }
    public ProductImages update(ProductImages object) {
        object.setCreationDate(new Date());
        return productImagesRepository.saveAndFlush(object);
    }
    public void exclude(Long id) {
        ProductImages object = productImagesRepository.findById(id).get();
        productImagesRepository.delete(object);
    }

}
