package com.crud.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductReadDTO {
    private int id;
    private String name;
    private int quantity;
    private double price;
}
