package com.kanivets.fibonacci_files.service;

import com.kanivets.fibonacci_files.exception.FibonacciException;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FibonacciSequenceGeneratorTest {

    FibonacciSequenceGenerator fibonacciSequenceGenerator = new FibonacciSequenceGenerator();
    List<Integer> testFibList = Stream.of(0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144)
            .collect(Collectors.toList());

    @Test
    public void getSequenceUpTo() throws FibonacciException {
        List<Integer> fibList = fibonacciSequenceGenerator.getSequenceUpTo(150);

        Assert.assertEquals(testFibList, fibList);
    }

}