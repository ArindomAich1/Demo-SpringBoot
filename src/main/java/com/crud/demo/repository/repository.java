package com.crud.demo.repository;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.crud.demo.entity.Product;

public interface repository extends JpaRepository<Product, Integer> {
    Optional<Product> findTopByOrderByIdDesc();
}
