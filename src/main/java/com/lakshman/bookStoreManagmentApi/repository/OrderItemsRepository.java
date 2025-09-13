package com.lakshman.bookStoreManagmentApi.repository;

import com.lakshman.bookStoreManagmentApi.entity.OrderItems;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemsRepository extends JpaRepository<OrderItems, Long> {
}
