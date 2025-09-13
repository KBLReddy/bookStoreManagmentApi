package com.lakshman.bookStoreManagmentApi.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class BookDto {
    @NotBlank(message = "title is required")
    private String title;
    @NotBlank(message = "author is required")
    private String author;
    @NotNull(message = "price is required")
    private Float price;
    @NotNull(message = "stock is required")
    private Integer stock;
}
