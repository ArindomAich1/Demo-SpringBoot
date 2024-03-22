package com.crud.demo.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.crud.demo.dao.Product;

public interface Repository extends JpaRepository<Product, Integer> {

}


