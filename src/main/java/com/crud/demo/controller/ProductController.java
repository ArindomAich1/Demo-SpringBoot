package com.crud.demo.controller;

import java.util.List;

import com.crud.demo.dao.User;
import com.crud.demo.dto.UserDTO;
import com.crud.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

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

    @Autowired
    private UserService userService;

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

    @PostMapping("/addUserAndProduct")
    public UserDTO addUserAndProduct(@RequestBody User user) {
        return userService.saveUserWithProducts(user, user.getProducts());
    }

    @DeleteMapping("/deleteUser/{id}")
    public String deleteUser(@PathVariable int id) {
        return userService.deleteUser(id);
    }

    @GetMapping("/getUsers")
    public List<UserDTO> getUsers() {
        return userService.getUsers();
    }

    
}
