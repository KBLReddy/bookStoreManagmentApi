package com.lakshman.bookStoreManagmentApi.exception;

import com.lakshman.bookStoreManagmentApi.dto.ErrorResponseDto;
import com.lakshman.bookStoreManagmentApi.exception.bookExceptions.BookCreationException;
import com.lakshman.bookStoreManagmentApi.exception.bookExceptions.ResourceNotFoundException;
import com.lakshman.bookStoreManagmentApi.exception.customerExceptions.CustomerCreationException;
import org.hibernate.exception.JDBCConnectionException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.CannotCreateTransactionException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(BookCreationException.class)
    public ResponseEntity<ErrorResponseDto> handleBookCreationException(BookCreationException e) {
        ErrorResponseDto errorResponseDto = new ErrorResponseDto(e.getMessage(), HttpStatus.BAD_REQUEST.value());
        return new ResponseEntity<>(errorResponseDto, HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler({CannotCreateTransactionException.class, JDBCConnectionException.class})
    public ResponseEntity<String> handleDatabaseConnectionException(RuntimeException e) {
        return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE)
                .body("Database is unavailable. Please try again later.");
    }
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ErrorResponseDto> handleResourceNotFoundException(ResourceNotFoundException e) {
        ErrorResponseDto errorResponseDto = new ErrorResponseDto(e.getMessage(),HttpStatus.NOT_FOUND.value());
        return new ResponseEntity<>(errorResponseDto, HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> handleValidationExceptions(
            MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getFieldErrors().forEach(error ->
                errors.put(error.getField(), error.getDefaultMessage())
        );
        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponseDto> handleGenericException(Exception e) {
        e.printStackTrace();

        ErrorResponseDto errorResponseDto =
                new ErrorResponseDto("Something went wrong. Please contact support.", HttpStatus.INTERNAL_SERVER_ERROR.value());

        return new ResponseEntity<>(errorResponseDto, HttpStatus.INTERNAL_SERVER_ERROR);
    }
    @ExceptionHandler(CustomerCreationException.class)
    public ResponseEntity<ErrorResponseDto> handleCustomerCreationException(CustomerCreationException e) {
        ErrorResponseDto errorResponseDto = new ErrorResponseDto(e.getMessage(), HttpStatus.BAD_REQUEST.value());
        return new ResponseEntity<>(errorResponseDto, HttpStatus.BAD_REQUEST);
    }


}

