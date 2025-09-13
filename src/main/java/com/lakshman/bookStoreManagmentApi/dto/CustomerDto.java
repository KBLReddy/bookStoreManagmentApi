package com.lakshman.bookStoreManagmentApi.dto;

import com.lakshman.bookStoreManagmentApi.entity.Order;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class CustomerDto {
    @NotBlank(message = "name can't be empty")
    private String name;
    @NotBlank(message = "email can't be empty")
    private String email;
}
