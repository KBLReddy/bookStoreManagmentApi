package com.lakshman.bookStoreManagmentApi.controller;

import com.lakshman.bookStoreManagmentApi.entity.Order;
import com.lakshman.bookStoreManagmentApi.service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrdersController {
    @Autowired
    private OrdersService ordersService;
    @PostMapping("/api/orders")
    public ResponseEntity<Order>

}
