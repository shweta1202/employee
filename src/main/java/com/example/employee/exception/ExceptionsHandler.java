package com.example.employee.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * The type Exceptions handler.
 */
@RestControllerAdvice
public class ExceptionsHandler {

    private final static Logger LOGGER = LoggerFactory.getLogger(ExceptionsHandler.class);

    /**
     * Bad request exception response entity.
     *
     * @param e the e
     * @return the response entity
     */
    @ExceptionHandler({BadRequestException.class})
    public ResponseEntity<String> badRequestException(Exception e) {
        return error(HttpStatus.BAD_REQUEST, e);
    }

    /**
     * Internal server error exception response entity.
     *
     * @param e the e
     * @return the response entity
     */
    @ExceptionHandler({InternalServerErrorException.class})
    public ResponseEntity<String> internalServerErrorException(Exception e) {
        return error(HttpStatus.INTERNAL_SERVER_ERROR, e);
    }

    private ResponseEntity<String> error(HttpStatus status, Exception e) {
        LOGGER.error("Exception: " + e);
        return ResponseEntity.status(status).body(e.getMessage());
    }
}
