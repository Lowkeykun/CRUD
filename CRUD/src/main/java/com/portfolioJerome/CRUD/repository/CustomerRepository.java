package com.portfolioJerome.CRUD.repository;

import com.portfolioJerome.CRUD.common.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {
}
