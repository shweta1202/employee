package com.example.employee.exception;

/**
 * The type Bad request exception.
 */
public class BadRequestException extends Exception{
    private static final long serialVersionUID = 1L;

    private String message;

    /**
     * Instantiates a new Bad request exception.
     */
    public BadRequestException() {
        super();
    }

    /**
     * Instantiates a new Bad request exception.
     *
     * @param message the message
     */
    public BadRequestException(String message) {
        super(message);
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
