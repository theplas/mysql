package com.codegym.repository;

import com.codegym.model.Customer;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface CustomerRepository extends PagingAndSortingRepository<Customer,Long> {
    Iterable<Customer> findAllByNameContains(String name);

    @Query(value = "select * from customers",nativeQuery = true)
    Iterable<Customer> findALlByQuery();
}
