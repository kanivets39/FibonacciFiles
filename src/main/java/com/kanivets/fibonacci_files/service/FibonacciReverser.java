package com.kanivets.fibonacci_files.service;

import com.kanivets.fibonacci_files.exception.FibonacciException;
import com.kanivets.fibonacci_files.exception.ReverseException;

import java.util.List;

/**
 * Fibonacci reverser service based on Fibonacci sequence that can reverse some data structures.
 */
public class FibonacciReverser implements Reverser{

    public List<String> reverseListStrings(List<String> list, StringReverser stringReverser) throws ReverseException {
        List<Integer> requiredFibonacci ;
        try {
            requiredFibonacci = new FibonacciSequenceGenerator().getSequenceUpTo(list.size());
        }catch (FibonacciException e){
            throw new ReverseException("Can`t reverse this list because of FibonacciException: "+ e.getLocalizedMessage());
        }
        int fib;
        for (int i = 2; i < requiredFibonacci.size(); i++) {
            fib = requiredFibonacci.get(i) - 1;
            list.set(fib, stringReverser.reverse(list.get(fib)));
        }

        return list;
    }

}
