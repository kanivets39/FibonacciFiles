package com.kanivets.fibonacci_files.service;

import com.kanivets.fibonacci_files.exception.FibonacciException;
import com.kanivets.fibonacci_files.exception.ReverseException;
import lombok.extern.log4j.Log4j2;

import java.util.List;

/**
 * Fibonacci reverser service based on Fibonacci sequence that can reverse some data structures.
 */
@Log4j2
public class FibonacciReverser implements Reverser {

    public List<String> reverseListStrings(List<String> list, StringReverser stringReverser) throws ReverseException {
        log.debug("Incoming data: "+ list);
        List<Integer> requiredFibonacci;
        try {
            requiredFibonacci = new FibonacciSequenceGenerator().getSequenceUpTo(list.size());
        } catch (FibonacciException e) {
            throw new ReverseException("Can`t reverse this list because of FibonacciException: " + e.getLocalizedMessage());
        }
        String reversed;
        int fib;
        for (int i = 2; i < requiredFibonacci.size(); i++) {
            fib = requiredFibonacci.get(i) - 1;
            reversed = stringReverser.reverse(list.get(fib));
            log.debug("Old string: " + list.get(fib) + ", new string: " + reversed);
            list.set(fib, reversed);
        }

        log.debug("Outgoing data: "+ list);
        return list;
    }

}
