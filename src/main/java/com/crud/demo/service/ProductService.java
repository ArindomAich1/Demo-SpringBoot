package com.crud.demo.service;

import java.time.Instant;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.List;

import com.crud.demo.exception.ProductNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crud.demo.dao.Product;
import com.crud.demo.dto.ProductCreateDTO;
import com.crud.demo.dto.ProductReadDTO;
import com.crud.demo.mapper.ProductMapper;
import com.crud.demo.repository.Repository;

@Service
public class ProductService {

    private static Logger LOGGER = LoggerFactory.getLogger(ProductService.class);

    @Autowired
    private Repository repository;

    @Autowired
    private ProductMapper mapper;



    private String generateProductCode() {
        Instant timestamp = Instant.now();
        OffsetDateTime utc = timestamp.atOffset(ZoneOffset.UTC);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMddHHmmssSSS");
        String timestampAsString = utc.format(formatter);
        
        System.out.println(timestampAsString);
        return String.format("prod"+timestampAsString);
    }
    
    public ProductReadDTO saveProduct(ProductCreateDTO productDTO) {

        Product product = mapper.dtoToDAOConversion(productDTO);
        String productCode = generateProductCode();

        product.setCode(productCode);

        Product savedProduct = repository.save(product);

        ProductReadDTO productReadDTO = mapper.daoToDTOConversion(savedProduct);

        return productReadDTO;
    }

    public List<ProductReadDTO> saveMultipleProduct(List<ProductCreateDTO> productDTOs) {

        List<Product> products = mapper.dtosToDAOConversion(productDTOs);

        for (Product product : products) {
            String productCode = generateProductCode(); // Ensure this method is defined elsewhere
            product.setCode(productCode);
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        
        LOGGER.info("saving list data {}", products);

        List<Product> savedProducts = repository.saveAll(products);

        List<ProductReadDTO> productReadDTOs = mapper.daosToDAOSConversion(savedProducts);

        return productReadDTOs;

    }

    public List<ProductReadDTO> getProducts() {
        List<Product> products = repository.findAll();
        LOGGER.info("fetched list data {}", products);
        List<ProductReadDTO> productDTOs = mapper.daosToDAOSConversion(products);
        return productDTOs;
    }

    public ProductReadDTO getProductById(int id){
        Product product = repository.findById(id).orElseThrow(() -> new ProductNotFoundException("Product with ID " + id + " not found."));;
        ProductReadDTO productDTO = mapper.daoToDTOConversion(product);
        return productDTO;
    }

    public String deleteProduct(int id) {
        Product product = repository.findById(id).orElseThrow(() -> new ProductNotFoundException("Product with ID " + id + " not found."));

        repository.deleteById(id);
        return "deleted id:"+id;
    }

    @SuppressWarnings("null")
    public ProductReadDTO updateProduct(ProductReadDTO productReadDTO) {
        Product product = repository.findById(productReadDTO.getId()).orElseThrow(() -> new ProductNotFoundException("Product with ID " + productReadDTO.getId() + " not found."));
        product.setName(productReadDTO.getName());
        product.setPrice(productReadDTO.getPrice());
        product.setQuantity(productReadDTO.getQuantity());

        Product savedProduct = repository.save(product);

        ProductReadDTO updatedProductReadDTO = new ProductReadDTO(
                savedProduct.getId(),
                savedProduct.getName(),
                savedProduct.getQuantity(),
                savedProduct.getPrice(),
                savedProduct.getUser().getId()
        );

        return updatedProductReadDTO;
    }
}
