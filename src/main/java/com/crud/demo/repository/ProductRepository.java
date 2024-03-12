package com.crud.demo.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.crud.demo.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {

}
