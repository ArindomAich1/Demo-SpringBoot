package com.crud.demo.controller;

import java.util.List;
// import org.hibernate.mapping.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.crud.demo.entity.Product;
import com.crud.demo.service.ProductService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
public class ProductController {
    @Autowired
    private ProductService service;
    
    @PostMapping("/addProduct")
    public Product addProduct(@RequestBody Product product) {
        return service.saveProduct(product);
    }

    @PostMapping("/addMultipleProduct")
    public List<Product> addMultipleProduct(@RequestBody List<Product> products) {
        return service.saveMultipleProduct(products);
    }

    @GetMapping("/getProducts")
    public List<Product> getProducts() {
        return service.getProducts();
    }

    @GetMapping("/getProductById")
    public Product getProductById(@RequestParam int id) {
        return service.getProductById(id);
    }

    @PutMapping("/updateProduct")
    public Product updateProduct(@RequestBody Product product) {
        return service.updateProduct(product);
    }

    @DeleteMapping("/deleteProduct")
    public String deleteProduct(@RequestParam int id) {
        return service.deleteProduct(id);
    }

    
}
