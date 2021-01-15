package com.codegym.service;

import com.codegym.model.Customer;
import com.codegym.model.Product;

import java.util.List;

public interface ProductService {
    Iterable<Product> findAll();

    void save(Product product);

    Product findById(Long id);

    void update(Product product);

    void remove(Long id);


}
