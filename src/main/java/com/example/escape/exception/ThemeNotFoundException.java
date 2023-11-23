package com.example.escape.exception;

public class ThemeNotFoundException extends RuntimeException {

    public ThemeNotFoundException(Long id) {
        super(id + "not found");
    }
}
