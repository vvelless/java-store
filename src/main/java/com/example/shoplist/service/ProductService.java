package com.example.shoplist.service;

import com.example.shoplist.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.shoplist.form.ProductForm;
import com.example.shoplist.repository.ProductRepository;

import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    ProductRepository productRepository;

    public Product add(ProductForm form) {
        return productRepository.save(new Product(form));
    }

    public void remove(Long id) {
        productRepository.deleteById(id);
    }

    public Optional<Product> getById(Long id) {
        return productRepository.findById(id);
    }

    public Iterable<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Product save(Product product) {
        return productRepository.save(product);
    }
}