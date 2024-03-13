package com.crud.demo.dto;

import com.crud.demo.entity.Product;

import lombok.Data;

@Data
public class productReadDTO {
    private int id;
    private String name;
    private int quantity;
    private double price;

    public productReadDTO(Product product) {
        this.id = product.getId();
        this.name = product.getName();
        this.quantity = product.getQuantity();
        this.price = product.getPrice();  
    }
}
