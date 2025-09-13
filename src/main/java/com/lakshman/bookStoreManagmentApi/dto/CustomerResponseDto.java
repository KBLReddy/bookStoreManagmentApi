package com.lakshman.bookStoreManagmentApi.dto;

import com.lakshman.bookStoreManagmentApi.entity.Order;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerResponseDto {
    private Long id;
    private String name;
    private String email;
    private List<Order> orders;
}
