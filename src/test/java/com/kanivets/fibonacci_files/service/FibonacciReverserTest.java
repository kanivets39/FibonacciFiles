package com.kanivets.fibonacci_files.service;

import com.kanivets.fibonacci_files.exception.FibonacciException;
import com.kanivets.fibonacci_files.exception.ReverseException;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

import static com.kanivets.fibonacci_files.test_config.TestConfiguration.testList;
import static com.kanivets.fibonacci_files.test_config.TestConfiguration.testListReverse;

public class FibonacciReverserTest {

    FibonacciReverser fibonacciReverser = new FibonacciReverser();
    StringReverserImpl stringReverser = new StringReverserImpl();

    @Test
    public void reverseListRows() throws ReverseException {
        List<String> reversedTestList = fibonacciReverser.reverseListStrings(testList, stringReverser);

        Assert.assertEquals(testListReverse, reversedTestList);
    }

}