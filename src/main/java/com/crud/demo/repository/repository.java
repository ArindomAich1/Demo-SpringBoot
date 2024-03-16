package com.crud.demo.repository;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.crud.demo.dao.Product;

public interface Repository extends JpaRepository<Product, Integer> {
    Optional<Product> findTopByOrderByIdDesc();
}
