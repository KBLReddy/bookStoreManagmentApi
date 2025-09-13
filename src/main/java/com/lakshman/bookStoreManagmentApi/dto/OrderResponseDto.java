package com.lakshman.bookStoreManagmentApi.dto;

import com.lakshman.bookStoreManagmentApi.entity.Order;
import lombok.Data;

import java.util.List;

@Data
public class OrderResponseDto {
    private Long orderId;
    private Long customerId;
    private List<Order> orders;
}
