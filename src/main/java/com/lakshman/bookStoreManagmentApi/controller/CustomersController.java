package com.lakshman.bookStoreManagmentApi.controller;

import com.lakshman.bookStoreManagmentApi.dto.CustomerDto;
import com.lakshman.bookStoreManagmentApi.dto.CustomerResponseDto;
import com.lakshman.bookStoreManagmentApi.entity.Customer;
import com.lakshman.bookStoreManagmentApi.service.CustomerService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CustomersController {
    @Autowired
    private CustomerService customerService;
    @PostMapping("/api/customers")
    public ResponseEntity<CustomerResponseDto> createCustomer(@Valid @RequestBody CustomerDto customerDto) {
        return new ResponseEntity<>(customerService.createCustomer(customerDto), HttpStatus.OK);
    }
    @GetMapping("/api/customers")
    public ResponseEntity<List<CustomerResponseDto>> getAllCustomers() {
        return new ResponseEntity<>(customerService.getAllCustomers(), HttpStatus.OK);
    }
    @GetMapping("/api/customers/{id}")
    public ResponseEntity<CustomerResponseDto> getCustomer(@PathVariable long id) {
        return new ResponseEntity<>(customerService.getCustomerById(id), HttpStatus.OK);
    }
    @PutMapping("/api/customers/{id}")
    public ResponseEntity<CustomerResponseDto> updateCustomer(@Valid @RequestBody CustomerDto customerDto, @PathVariable long id) {
        return new ResponseEntity<>(customerService.updateCustomer(id, customerDto), HttpStatus.OK);
    }
    @DeleteMapping("/api/customers/{id}")
    public ResponseEntity<CustomerResponseDto> deleteCustomer(@PathVariable long id) {
        return new ResponseEntity<>(customerService.deleteCustomer(id), HttpStatus.OK);
    }

}
