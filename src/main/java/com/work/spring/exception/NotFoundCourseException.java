package com.work.spring.exception;

public class NotFoundCourseException extends RuntimeException {

    public NotFoundCourseException(String message) {
        super(message);
    }
}
