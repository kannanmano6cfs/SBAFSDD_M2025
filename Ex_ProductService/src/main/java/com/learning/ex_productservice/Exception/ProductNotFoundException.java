package com.learning.ex_productservice.Exception;

public class ProductNotFoundException extends RuntimeException {
    public ProductNotFoundException(int id) {
        super("Product with ID "+id+" not found");
    }
}
