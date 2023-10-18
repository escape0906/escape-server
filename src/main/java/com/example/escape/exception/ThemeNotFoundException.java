package com.example.escape.exception;

public class ThemeNotFoundException extends RuntimeException {

    public ThemeNotFoundException(Long id) {
        super(id + "를 찾을 수 없습니다.");
    }
}
