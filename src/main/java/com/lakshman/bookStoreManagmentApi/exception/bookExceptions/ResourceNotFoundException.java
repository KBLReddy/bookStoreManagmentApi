package com.lakshman.bookStoreManagmentApi.exception.bookExceptions;

public class ResourceNotFoundException extends RuntimeException{
    public ResourceNotFoundException(String message) {
        super(message);
    }
}
