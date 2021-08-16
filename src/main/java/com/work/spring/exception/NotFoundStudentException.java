package com.work.spring.exception;

public class NotFoundStudentException extends RuntimeException {
    public NotFoundStudentException(String message) {
        super(message);
    }
}
