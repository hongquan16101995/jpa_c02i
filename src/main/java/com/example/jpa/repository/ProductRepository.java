package com.example.jpa.repository;

import com.example.jpa.model.Product;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Transactional
@Repository
public class ProductRepository {
    @PersistenceContext
    private EntityManager entityManager;

    public List<Product> findAll() {
        String query = "select p from Product p";
        TypedQuery<Product> typedQuery = entityManager.createQuery(query, Product.class);
        return typedQuery.getResultList();
    }

    public void create(Product product) {
        entityManager.persist(product);
    }

    public void update(Product product) {
        entityManager.merge(product);
    }

    public Product findById(Long id) {
        return entityManager.find(Product.class, id);
    }

    public void delete(Long id) {
        Product product = findById(id);
        entityManager.remove(product);
    }

    public List<Product> findByPrice(Double price) {
        String query = "select p from Product p where p.price > :price";
        TypedQuery<Product> typedQuery = entityManager.createQuery(query, Product.class);
        typedQuery.setParameter("price", price);
        return typedQuery.getResultList();
    }
}
