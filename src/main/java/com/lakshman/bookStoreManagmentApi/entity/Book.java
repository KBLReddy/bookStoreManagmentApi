package com.lakshman.bookStoreManagmentApi.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "book",uniqueConstraints = @UniqueConstraint(columnNames = {"title","author"}))
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @NotNull
    private String title;
    @NotNull
    private String author;
    @NotNull
    private Float price;
    @NotNull
    private Integer stock;
}
