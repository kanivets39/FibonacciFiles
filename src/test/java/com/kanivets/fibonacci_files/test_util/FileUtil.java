package com.kanivets.fibonacci_files.test_util;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class FileUtil {

    public void clear(String path) throws FileNotFoundException {
        PrintWriter writer = new PrintWriter(path);
        writer.print("");
        writer.close();
    }

}
