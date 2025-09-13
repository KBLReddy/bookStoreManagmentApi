package com.lakshman.bookStoreManagmentApi.dto;

import lombok.Data;

import java.util.List;

@Data
public class CreateOrderRequestDto {
    private Long customerId;
    private List<OrderItemRequestDto> items;
}
