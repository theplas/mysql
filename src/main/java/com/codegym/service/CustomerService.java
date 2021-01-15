package com.codegym.service;

import com.codegym.model.Customer;

import java.util.List;

public interface CustomerService {
    Iterable<Customer> findAll();

    void save(Customer customer);

    Customer findById(Long id);

    void update(Customer customer);

    void remove(Long id);

    Iterable<Customer> searchByName(String name);
}
