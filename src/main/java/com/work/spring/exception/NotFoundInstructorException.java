package com.work.spring.exception;

public class NotFoundInstructorException extends RuntimeException {
    public NotFoundInstructorException(String message) {
        super(message);
    }
}
