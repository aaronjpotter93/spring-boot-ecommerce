package com.aaron.angularboot.dao;

import com.aaron.angularboot.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
