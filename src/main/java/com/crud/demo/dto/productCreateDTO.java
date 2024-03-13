package com.crud.demo.dto;

import com.crud.demo.entity.Product;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class productCreateDTO {
    // private int id;
    private String name;
    private int quantity;
    private double price;

    // public ProductDTO(Product product) {
    //     // this.id = product.getId();
    //     this.name = product.getName();
    //     this.quantity = product.getQuantity();
    //     this.price = product.getPrice();  
    // }

}

