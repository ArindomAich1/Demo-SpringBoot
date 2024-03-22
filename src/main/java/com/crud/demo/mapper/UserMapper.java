package com.crud.demo.mapper;

import java.util.List;

import com.crud.demo.dao.User;
import com.crud.demo.dto.ProductCreateDTO;
import com.crud.demo.dto.ProductReadDTO;
import com.crud.demo.dto.UserDTO;
import org.mapstruct.Mapper;

import com.crud.demo.dao.Product;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserDTO daoToDTOConversion(User user);

}
