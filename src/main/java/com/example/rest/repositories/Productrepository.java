package com.example.rest.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.rest.entities.Product;

public interface Productrepository extends JpaRepository<Product, Long>{

}
