package com.crud.demo.service;

import com.crud.demo.dao.Product;
import com.crud.demo.dao.User;
import com.crud.demo.dto.ProductReadDTO;
import com.crud.demo.dto.UserDTO;
import com.crud.demo.mapper.ProductMapper;
import com.crud.demo.mapper.UserMapper;
import com.crud.demo.repository.Repository;
import com.crud.demo.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.stream.Collectors;

import java.time.Instant;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private Repository productRepository;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private  ProductMapper productMapper;

    private static Logger LOGGER = LoggerFactory.getLogger(UserService.class);

    private String generateProductCode() {
        Instant timestamp = Instant.now();
        OffsetDateTime utc = timestamp.atOffset(ZoneOffset.UTC);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMddHHmmssSSS");
        String timestampAsString = utc.format(formatter);

        System.out.println(timestampAsString);
        return String.format("prod"+timestampAsString);
    }

    @Transactional  //AOP concept and types
    public UserDTO saveUserWithProducts(User user, List<Product> products) {
        // Save the user first
        User savedUser = userRepository.save(user);

        // Set the user for each product and save
        products.forEach(product -> product.setUser(savedUser));

        for (Product product : products) {
            String productCode = generateProductCode(); // Ensure this method is defined elsewhere
            product.setCode(productCode);
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }

        List<Product> savedProducts = productRepository.saveAll(products);

        List<ProductReadDTO> productDTOs = productMapper.daosToDAOSConversion(savedProducts);

        UserDTO userDTO = userMapper.daoToDTOConversion(savedUser);
        // Update the user's product list (optional, depending on whether you want to use it later)
        userDTO.setProductDTOs(productDTOs);



        return userDTO;
    }

    public String deleteUser(int id) {
        userRepository.deleteById(id);
        return "User has been deleted";
    }

    public List<UserDTO> getUsers() {
        List<User> users = userRepository.findAll();

        List<UserDTO> userDTOs = users.stream().map(user ->
                new UserDTO(
                        user.getId(),
                        user.getName(),
                        productMapper.daosToDAOSConversion(user.getProducts())
                )
        ).collect(Collectors.toList());
        //SQL or OQL

        LOGGER.info("getting list data {}", userDTOs);
        return userDTOs;
    }
}
