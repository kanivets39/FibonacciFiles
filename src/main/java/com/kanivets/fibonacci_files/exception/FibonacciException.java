package com.kanivets.fibonacci_files.exception;

/**
 * Fibonacci exception.
 * Thrown when an some Fibonacci operation exceptional condition has occurred.
 */
public class FibonacciException extends Exception {

    /**
     * Instantiates a new Fibonacci exception.
     */
    public FibonacciException() {
    }

    /**
     * Instantiates a new Fibonacci exception.
     *
     * @param message the message
     */
    public FibonacciException(String message) {
        super(message);
    }

}
