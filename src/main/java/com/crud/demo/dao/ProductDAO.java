package com.crud.demo.dao;


import org.springframework.data.jpa.repository.JpaRepository;

import com.crud.demo.entity.Product;

public interface ProductDAO extends JpaRepository<Product, Integer> {

}
