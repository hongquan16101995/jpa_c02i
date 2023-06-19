package com.example.jpa.repository;

import com.example.jpa.model.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IProductRepository extends CrudRepository<Product, Long> {
    List<Product> findAllByPriceGreaterThan(Double price);

    List<Product> findAllByQuantityLessThan(Integer quantity);
}
