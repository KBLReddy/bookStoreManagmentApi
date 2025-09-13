package com.lakshman.bookStoreManagmentApi.service;

import com.lakshman.bookStoreManagmentApi.dto.CustomerDto;
import com.lakshman.bookStoreManagmentApi.dto.CustomerResponseDto;
import com.lakshman.bookStoreManagmentApi.entity.Customer;
import com.lakshman.bookStoreManagmentApi.entity.Order;
import com.lakshman.bookStoreManagmentApi.exception.bookExceptions.ResourceNotFoundException;
import com.lakshman.bookStoreManagmentApi.exception.customerExceptions.CustomerCreationException;
import com.lakshman.bookStoreManagmentApi.repository.CustomerRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class CustomerService {
    @Autowired
    private CustomerRepository customerRepository;
    @Transactional
    public CustomerResponseDto createCustomer(@Valid @RequestBody CustomerDto customerDto) {
            Customer customer = new Customer();
            customer.setName(customerDto.getName());
            customer.setEmail(customerDto.getEmail());
            customerRepository.save(customer);
            return mapToDto(customer);
    }
    public List<CustomerResponseDto> getAllCustomers() {
            return customerRepository.findAll().stream()
                    .map(this::mapToDto).toList();

    }
    public CustomerResponseDto getCustomerById(Long id) {
        try {
            return mapToDto(customerRepository.findById(id).get());
        }
        catch (EntityNotFoundException e) {
            throw new ResourceNotFoundException("Customer not found with id " + id);

        }
    }
    public CustomerResponseDto updateCustomer(Long id, @Valid @RequestBody CustomerDto customerDto) {
        Customer customer = new Customer();
        customer.setId(id);
        customer.setName(customerDto.getName());
        customer.setEmail(customerDto.getEmail());
       customerRepository.save(customer);
       return mapToDto(customer);

    }
    public CustomerResponseDto deleteCustomer(Long id) {
        CustomerResponseDto customerResponseDto = mapToDto(customerRepository.findById(id).get());
        customerRepository.deleteById(id);
        return customerResponseDto;

    }
    private CustomerResponseDto mapToDto(Customer customer) {
        CustomerResponseDto customerResponseDto = new CustomerResponseDto();
        customerResponseDto.setId(customer.getId());
        customerResponseDto.setName(customer.getName());
        customerResponseDto.setEmail(customer.getEmail());
        return customerResponseDto;
    }
    private Customer mapToEntity(CustomerResponseDto customerResponseDto) {
        Customer customer = new Customer();
        customer.setId(customerResponseDto.getId());
        customer.setName(customerResponseDto.getName());
        customer.setEmail(customerResponseDto.getEmail());
        return customer;
    }

}
