package com.example.employee.dto;

/**
 * The type Response dto.
 */
public class ResponseDto {

    private String id;
    private String message;

    /**
     * Instantiates a new Response dto.
     *
     * @param message the message
     * @param id      the id
     */
    public ResponseDto(String message, String id) {
        this.message = message;
        this.id = id;
    }

    /**
     * Gets id.
     *
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * Sets id.
     *
     * @param id the id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Gets message.
     *
     * @return the message
     */
    public String getMessage() {
        return message;
    }

    /**
     * Sets message.
     *
     * @param message the message
     */
    public void setMessage(String message) {
        this.message = message;
    }
}
