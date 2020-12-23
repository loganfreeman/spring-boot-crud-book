package com.example.demo.exceptions;

public class BookNotFoundException extends RuntimeException {
    public BookNotFoundException(String exception) {
        super(exception);
    }
}
