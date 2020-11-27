package com.kanivets.fibonacci_files.service;

import com.kanivets.fibonacci_files.exception.ReverseException;
import com.kanivets.fibonacci_files.io.FileNIO;
import com.kanivets.fibonacci_files.test_util.FileUtil;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import static com.kanivets.fibonacci_files.test_config.TestConfiguration.*;

public class FibonacciReverseFileRowsTest {

    private final FibonacciReverser fibonacciReverser = new FibonacciReverser();
    private final FileNIO fileNIO = new FileNIO();
    private final FileUtil fileUtil = new FileUtil();

    @Before
    public void before() throws FileNotFoundException {
        fileUtil.clear(testOutFilePath);
    }

    @Test
    public void reverseFileRows() throws IOException, ReverseException {
        List<String> fileData = fileNIO.read(testInFilePath);
        fileData = fibonacciReverser.reverseListStrings(fileData, new StringReverserImpl());
        fileNIO.write(testOutFilePath, fileData);

        List<String> testListResult = fileNIO.read(testOutFilePath);
        Assert.assertEquals(testListReverse, testListResult);
    }

}
