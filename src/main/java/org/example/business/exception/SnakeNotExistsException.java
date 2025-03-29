package org.example.business.exception;

public class SnakeNotExistsException extends RuntimeException {
    public SnakeNotExistsException(String msg) {
        super(msg);
    }
}
