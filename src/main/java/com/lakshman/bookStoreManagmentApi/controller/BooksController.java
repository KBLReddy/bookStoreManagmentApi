package com.lakshman.bookStoreManagmentApi.controller;

import com.lakshman.bookStoreManagmentApi.dto.BookDto;
import com.lakshman.bookStoreManagmentApi.dto.BookResponseDto;
import com.lakshman.bookStoreManagmentApi.entity.Book;
import com.lakshman.bookStoreManagmentApi.exception.bookExceptions.BookCreationException;
import com.lakshman.bookStoreManagmentApi.service.BookService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BooksController {
    @Autowired
    private BookService bookService;

    @PostMapping("/api/books")
    public ResponseEntity<BookResponseDto> createBook(@Valid @RequestBody BookDto book) {
            return new ResponseEntity<>(bookService.createBook(book), HttpStatus.OK);
    }
    @GetMapping("/api/books")
    public ResponseEntity<List<BookResponseDto>> getAllBooks() {
        return new ResponseEntity<>(bookService.getAllBooks(), HttpStatus.OK);
    }
    @GetMapping("/api/books/{id}")
    public ResponseEntity<BookResponseDto> getBookById(@PathVariable Long id) {
        return new ResponseEntity<>(bookService.getBookById(id), HttpStatus.OK);
    }
    @PutMapping("/api/books/{id}")
    public ResponseEntity<BookResponseDto> updateBook(@PathVariable Long id, @Valid @RequestBody BookDto bookDto) {
        return new ResponseEntity<>(bookService.updateBook(id,bookDto), HttpStatus.OK);

    }
    @DeleteMapping("/api/books/{id}")
    public ResponseEntity<BookResponseDto> deleteBook(@PathVariable Long id) {
        return new ResponseEntity<>(bookService.deleteBookById(id),HttpStatus.OK);
    }

}
