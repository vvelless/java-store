package com.example.shoplist.controller;

import com.example.shoplist.form.ProductForm;
import com.example.shoplist.model.Product;
import com.example.shoplist.service.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api")
public class RController {
    private final ProductService productService;

    public RController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/")
    private Iterable<Product> list() {
        return productService.getAllProducts();
    }

    @GetMapping("/{id}")
    private Optional<Product> getById(@PathVariable("id") Long id) {
        return productService.getById(id);
    }

    @PostMapping("/remove/{id}")
    private void delete(@PathVariable("id") Long id) {
        productService.remove(id);
    }

    @PostMapping("/update/{id}")
    private void update(@PathVariable("id") Long id) {
        productService.getById(id).ifPresent(product -> {
            product.setBought(!product.isBought());
            productService.save(product);
        });
    }

    @PostMapping("/add")
    private Product addProduct(@RequestBody ProductForm form) {
        return productService.add(form);
    }
}
