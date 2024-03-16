package com.crud.demo.mapper;

import java.util.List;

import com.crud.demo.dto.ProductCreateDTO;
import com.crud.demo.dto.ProductReadDTO;
import org.mapstruct.Mapper;

import com.crud.demo.dao.Product;

@Mapper(componentModel = "spring")
public interface ProductMapper {

    List<ProductReadDTO> daosToDAOSConversion(List<Product> products);
    ProductReadDTO daoToDTOConversion(Product product);

    Product dtoToDAOConversion(ProductCreateDTO productCreateDTO);
    List<Product> dtosToDAOConversion(List<ProductCreateDTO> productCreateDTOS);

}
