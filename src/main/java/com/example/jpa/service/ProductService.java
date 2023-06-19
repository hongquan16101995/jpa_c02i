package com.example.jpa.service;

import com.example.jpa.model.Product;
import com.example.jpa.repository.IProductRepository;
import com.example.jpa.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService implements ICRUDService{

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private IProductRepository iProductRepository;

    @Override
    public List<Product> findAll() {
//        return productRepository.findAll();
        return (List<Product>) iProductRepository.findAll();
    }

    @Override
    public Product findById(Long id) {
        return productRepository.findById(id);
    }

    @Override
    public void create(Product product) {
        productRepository.create(product);
    }

    @Override
    public void update(Product product) {
        productRepository.update(product);
    }

    @Override
    public void delete(Long id) {
        productRepository.delete(id);
    }

    @Override
    public List<Product> findByPrice() {
//        return productRepository.findByPrice();
        return iProductRepository.findAllByPriceGreaterThan(100D);
    }
}
