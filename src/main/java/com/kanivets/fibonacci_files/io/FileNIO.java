package com.kanivets.fibonacci_files.io;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Paths;
import java.util.List;

/**
 * File Non-blocking Input/Output.
 */
public class FileNIO implements FileIO {

    public List<String> read(String path) throws IOException {
        List<String> list;
        if (Files.exists(Paths.get(path)))
            list = Files.readAllLines(Paths.get(path), Charset.defaultCharset());
         else throw new NoSuchFileException("File is`t exist: " + path);

        return list;
    }

    public void write(String path, List<String> list) throws IOException {
        if (Files.exists(Paths.get(path)))
            Files.write(Paths.get(path), list, Charset.defaultCharset());
         else throw new NoSuchFileException("File is`t exist: " + path);
    }

}
