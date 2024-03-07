package com.crud.demo.service;

import java.util.List;
// import org.hibernate.mapping.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    public List<Product> getProducts() {
        return repository.findAll();
    }

    public Product getProductById(int id) {
        return repository.findById(id).orElse(null);
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
