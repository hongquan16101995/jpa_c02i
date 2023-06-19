package com.example.jpa.service;

import com.example.jpa.model.Product;

import java.util.List;

public interface ICRUDService {

    List<Product> findAll();

    Product findById(Long id);

    void create(Product product);

    void update(Product product);

    void delete(Long id);

    List<Product> findByPrice();
}
