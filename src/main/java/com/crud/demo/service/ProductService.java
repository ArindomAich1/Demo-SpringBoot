package com.crud.demo.service;

import java.util.List;
import java.util.Optional;

// import org.hibernate.mapping.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crud.demo.dto.productCreateDTO;
import com.crud.demo.dto.productReadDTO;
import com.crud.demo.entity.Product;
import com.crud.demo.repository.repository;

@Service
public class ProductService {
    @Autowired
    private repository repository;

    private String generateProductCode() {
        Optional<Product> lastProduct = repository.findTopByOrderByIdDesc();
        long nextId = lastProduct.map(product -> product.getId() + 1).orElse(1);
        return String.format("prod%04d", nextId);
    }
    
    public Product saveProduct(productCreateDTO productDTO) {
        Product product = new Product();
        product.setName(productDTO.getName());
        product.setQuantity(productDTO.getQuantity());
        product.setPrice(productDTO.getPrice());

        String productCode = generateProductCode();
        product.setCode(productCode);
        return repository.save(product);
    }

    @SuppressWarnings("null")
    public List<Product> saveMultipleProduct(List<Product> products) {
        return repository.saveAll(products);   
    }

    //chang to ProductDTO
    public List<productReadDTO> getProducts() {
        List<Product> products = repository.findAll();
        List<productReadDTO> productDTOs = products.stream().map(product -> new productReadDTO(product)).toList();
        return productDTOs;
    }

    // public Product getProductById(int id) {
    //     return repository.findById(id).orElse(null);
    // }

    public productReadDTO getProductById(int id){
        Product product = repository.findById(id).orElse(null);
        // System.out.println(product);
        productReadDTO productDTO = new productReadDTO(product);
        // System.out.println("productDTO: "+productDTO);
        return productDTO;
    }

    public String deleteProduct(int id) {
        repository.deleteById(id);
        return "deleted id:"+id;
    }

    @SuppressWarnings("null")
    public Product updateProduct(Product product) {
        return repository.save(product);
    }
}
