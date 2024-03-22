package com.crud.demo.mapper;

import java.util.List;

import com.crud.demo.dao.User;
import com.crud.demo.dto.ProductCreateDTO;
import com.crud.demo.dto.ProductReadDTO;
import com.crud.demo.dto.UserDTO;
import org.mapstruct.Mapper;

import com.crud.demo.dao.Product;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ProductMapper {

    @Mapping(source = "user.id", target = "user_id")
    List<ProductReadDTO> daosToDAOSConversion(List<Product> products);
    @Mapping(source = "user.id", target = "user_id")
    ProductReadDTO daoToDTOConversion(Product product);

    Product dtoToDAOConversion(ProductCreateDTO productCreateDTO);
    List<Product> dtosToDAOConversion(List<ProductCreateDTO> productCreateDTOS);

}
