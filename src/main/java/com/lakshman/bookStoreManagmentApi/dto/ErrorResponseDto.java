package com.lakshman.bookStoreManagmentApi.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class ErrorResponseDto {
    private String message;
    private Integer status;
}
