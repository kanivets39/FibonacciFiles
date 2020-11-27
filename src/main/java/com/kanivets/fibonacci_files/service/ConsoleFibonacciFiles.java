package com.kanivets.fibonacci_files.service;

import com.kanivets.fibonacci_files.exception.ReverseException;
import com.kanivets.fibonacci_files.io.ConsoleIO;
import com.kanivets.fibonacci_files.io.ConsoleUI;
import com.kanivets.fibonacci_files.io.FileNIO;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.nio.file.NoSuchFileException;
import java.util.List;

public class ConsoleFibonacciFiles {

    private final PrintStream printStream = new PrintStream(System.out);
    private final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    private final ConsoleIO consoleIO = new ConsoleIO(bufferedReader, printStream);
    private final ConsoleUI consoleUI = new ConsoleUI(consoleIO);
    private final FileNIO fileNIO = new FileNIO();
    private final FibonacciReverser fibonacciReverser = new FibonacciReverser();
    private final StringReverserImpl stringReverser = new StringReverserImpl();

    public void start() {
        boolean loop = true;
        while (loop) {
            try {
                String inPath = consoleUI.inputFilePath("read");
                List<String> rowsList = fileNIO.read(inPath);
                List<String> reverseRowsList = fibonacciReverser.reverseListStrings(rowsList, stringReverser);
                String outPath = consoleUI.inputFilePath("output");
                fileNIO.write(outPath, reverseRowsList);
            } catch (NoSuchFileException e) {
                consoleUI.print(e.getMessage());
            } catch (IOException e) {
                consoleUI.print("Incorrect input");
            } catch (ReverseException e) {
                consoleUI.print("Trouble with reverse: " + e.getMessage());
            } catch (Exception e) {
                e.printStackTrace();
                consoleUI.print("Something gone wrong. Please try again");
            }

            try {
                loop = consoleUI.requestContinuation();
            } catch (IOException e) {
                consoleUI.print("Incorrect input");
            }
        }
    }

}
