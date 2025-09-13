package com.lakshman.bookStoreManagmentApi.exception.customerExceptions;

import org.springframework.dao.DataIntegrityViolationException;

public class CustomerCreationException extends RuntimeException{
      public CustomerCreationException(String message) {
          super(message);

      }
}
