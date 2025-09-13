package com.lakshman.bookStoreManagmentApi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.lakshman.bookStoreManagmentApi.entity.Customer;


public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
