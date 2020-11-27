package com.kanivets.fibonacci_files.io;

import com.kanivets.fibonacci_files.test_util.FileUtil;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import static com.kanivets.fibonacci_files.test_config.TestConfiguration.*;

public class FileNIOTest {

    private final FileNIO fileNIO = new FileNIO();
    private final FileUtil fileUtil = new FileUtil();

    @Before
    public void before() throws FileNotFoundException {
        fileUtil.clear(testOutFilePath);
    }

    @Test
    public void testReadInList() throws IOException {
        List<String> fileTestList = fileNIO.read(testInFilePath);

        Assert.assertEquals(testList, fileTestList);
    }

    @Test
    public void testWriteList() throws IOException {
        fileNIO.write(testOutFilePath, testList);

        Assert.assertEquals(testList, fileNIO.read(testOutFilePath));
    }


}