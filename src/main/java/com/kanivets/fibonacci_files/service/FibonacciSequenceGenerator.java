package com.kanivets.fibonacci_files.service;

import com.kanivets.fibonacci_files.exception.FibonacciException;
import lombok.extern.log4j.Log4j2;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Fibonacci sequence generator.
 */
@Log4j2
public class FibonacciSequenceGenerator {

    /**
     * Gets Fibonacci sequence List up to maximum permitted value.
     *
     * @param max the max value of sequence
     * @return the Fibonacci sequence
     * @throws FibonacciException the fibonacci exception
     */
    public List<Integer> getSequenceUpTo(int max) throws FibonacciException {
        List<Integer> fibonacci = Stream.of(0, 1).collect(Collectors.toList());
        int currentMax = 0;

        if (max < 0) {
            log.error("Maximum value invalid: "+ max);
            throw new FibonacciException("The maximum value must be greater than 0");
        } else {
            while (currentMax < max) {
                currentMax = fibonacci.get(fibonacci.size() - 2) + fibonacci.get(fibonacci.size() - 1);
                if (currentMax < max) {
                    fibonacci.add(currentMax);
                }
            }
        }
        log.debug("Fibonacci sequence for max value: " +max+ " is - "+ fibonacci.toString());
        return fibonacci;
    }
}
