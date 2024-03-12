package com.crud.demo.service;

import java.util.List;
// import org.hibernate.mapping.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crud.demo.dto.ProductDTO;
import com.crud.demo.entity.Product;
import com.crud.demo.repository.ProductRepository;

@Service
public class ProductService {
    @Autowired
    private ProductRepository repository;

    @SuppressWarnings("null")
    public Product saveProduct(Product product) {
        return repository.save(product);
    }

    @SuppressWarnings("null")
    public List<Product> saveMultipleProduct(List<Product> products) {
        return repository.saveAll(products);   
    }

    //chang to ProductDTO
    public List<ProductDTO> getProducts() {
        List<Product> products = repository.findAll();
        List<ProductDTO> productDTOs = products.stream().map(product -> new ProductDTO(product)).toList();
        return productDTOs;
    }

    // public Product getProductById(int id) {
    //     return repository.findById(id).orElse(null);
    // }

    public ProductDTO getProductById(int id){
        Product product = repository.findById(id).orElse(null);
        // System.out.println(product);
        ProductDTO productDTO = new ProductDTO(product);
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
