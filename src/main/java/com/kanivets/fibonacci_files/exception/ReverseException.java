package com.kanivets.fibonacci_files.exception;

/**
 * Reverse exception.
 * Thrown when an some reverse operation exceptional condition has occurred.
 */
public class ReverseException extends Exception {

    /**
     * Instantiates a new Reverse exception.
     */
    public ReverseException() {
    }

    /**
     * Instantiates a new Reverse exception.
     *
     * @param message the message
     */
    public ReverseException(String message) {
        super(message);
    }

}
