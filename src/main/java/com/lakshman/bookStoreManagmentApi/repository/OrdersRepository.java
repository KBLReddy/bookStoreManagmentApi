package com.lakshman.bookStoreManagmentApi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.lakshman.bookStoreManagmentApi.entity.Order;


public interface OrdersRepository extends JpaRepository<Order, Long> {
}
