package com.crud.demo.dto;

import com.crud.demo.entity.Product;

import lombok.Data;

@Data
public class ProductDTO {
    private int id;
    private String name;
    private int quantity;
    private double price;

    public ProductDTO(Product product) {
        this.id = product.getId();
        this.name = product.getName();
        this.quantity = product.getQuantity();
        this.price = product.getPrice();  
    }

}
