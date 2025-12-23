package com.ram.lb.exception;

public class MaxCapacityExceededException extends RuntimeException {
    public MaxCapacityExceededException(String message) {
        super(message);
    }
    public MaxCapacityExceededException(String message, Throwable cause) {
        super(message, cause);
    }
}
