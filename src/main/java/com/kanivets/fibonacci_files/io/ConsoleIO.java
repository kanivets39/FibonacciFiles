package com.kanivets.fibonacci_files.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;

/**
 * Console input|output.
 */
public class ConsoleIO implements Input, Output {

    private final BufferedReader bufferedReader;
    private final PrintStream printStream;

    /**
     * Instantiates a new Console input|output.
     *
     * @param bufferedReader the buffered reader
     * @param printStream    the print stream
     */
    public ConsoleIO(BufferedReader bufferedReader, PrintStream printStream) {
        this.bufferedReader = bufferedReader;
        this.printStream = printStream;
    }

    @Override
    public String read() throws IOException {
        return bufferedReader.readLine();
    }

    @Override
    public void write(String s) {
        printStream.println(s);
    }

}
