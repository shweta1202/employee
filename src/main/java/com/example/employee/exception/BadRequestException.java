package com.example.employee.exception;

public class BadRequestException extends Exception{
    private static final long serialVersionUID = 1L;

    private String message;

    public BadRequestException() {
        super();
    }

    public BadRequestException(String message) {
        super(message);
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
