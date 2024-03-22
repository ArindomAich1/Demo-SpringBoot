package com.crud.demo.dto;

import com.crud.demo.dao.Product;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {
    private int id;
    private String name;
    private List<ProductReadDTO> productDTOs;
}
