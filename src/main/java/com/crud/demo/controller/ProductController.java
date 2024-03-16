package com.crud.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.crud.demo.dao.Product;
import com.crud.demo.dto.ProductCreateDTO;
import com.crud.demo.dto.ProductReadDTO;
import com.crud.demo.service.ProductService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@RestController
public class ProductController {
    @Autowired
    private ProductService service;

    @PostMapping("/addProduct")
    public ProductReadDTO addProduct(@RequestBody ProductCreateDTO productDTO) {
        return service.saveProduct(productDTO);
    }

    @PostMapping("/addMultipleProduct")
    public List<ProductReadDTO> addMultipleProduct(@RequestBody List<ProductCreateDTO> productCreateDTOSDTOs) {
        return service.saveMultipleProduct(productCreateDTOSDTOs);
    }

    @GetMapping("/getProducts")
    public List<ProductReadDTO> getProducts() {
        return service.getProducts();
    }

    // @GetMapping(value = "/getProductById/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @GetMapping("/getProductById/{id}")
    public ProductReadDTO getProductById(@PathVariable int id) {
        return service.getProductById(id);
    }

    @PutMapping("/updateProduct")
    public ProductReadDTO updateProduct(@RequestBody ProductReadDTO productReadDTO) {
        return service.updateProduct(productReadDTO);
    }

    @DeleteMapping("/deleteProduct/{id}")
    public String deleteProduct(@PathVariable int id) {
        return service.deleteProduct(id);
    }

    
}
