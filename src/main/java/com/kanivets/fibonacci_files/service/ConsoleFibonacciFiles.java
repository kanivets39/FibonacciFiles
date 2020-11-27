package com.kanivets.fibonacci_files.service;

import com.kanivets.fibonacci_files.exception.ReverseException;
import com.kanivets.fibonacci_files.io.ConsoleIO;
import com.kanivets.fibonacci_files.io.ConsoleUI;
import com.kanivets.fibonacci_files.io.FileNIO;
import lombok.extern.log4j.Log4j2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.nio.file.NoSuchFileException;
import java.util.Arrays;
import java.util.List;

@Log4j2
public class ConsoleFibonacciFiles {

    private final PrintStream printStream = new PrintStream(System.out);
    private final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    private final ConsoleIO consoleIO = new ConsoleIO(bufferedReader, printStream);
    private final ConsoleUI consoleUI = new ConsoleUI(consoleIO);
    private final FileNIO fileNIO = new FileNIO();
    private final FibonacciReverser fibonacciReverser = new FibonacciReverser();
    private final StringReverserImpl stringReverser = new StringReverserImpl();

    public void start() {
        log.info("Execution started");
        boolean loop = true;
        while (loop) {
            try {
                String inPath = consoleUI.inputFilePath("read");
                log.debug("User input file path: " + inPath);
                List<String> rowsList = fileNIO.read(inPath);
                log.debug("Rows list: " + rowsList);
                List<String> reverseRowsList = fibonacciReverser.reverseListStrings(rowsList, stringReverser);
                log.debug("Reversed rows list: " + reverseRowsList);
                String outPath = consoleUI.inputFilePath("output");
                log.debug("User output file path: " + outPath);
                fileNIO.write(outPath, reverseRowsList);
            } catch (NoSuchFileException e) {
                consoleUI.print(e.getMessage());
                log.error("File does`t exist: " + Arrays.toString(e.getStackTrace()));
            } catch (IOException e) {
                consoleUI.print(e.getMessage());
                log.error(Arrays.toString(e.getStackTrace()));
            } catch (ReverseException e) {
                consoleUI.print("Trouble with reverse: " + e.getMessage());
                log.error("Exception in reversing operation: " + Arrays.toString(e.getStackTrace()));
            } catch (Exception e) {
                consoleUI.print("Something gone wrong. Please try again");
                log.error("Exception in ConsoleFibonacciFiles: " + Arrays.toString(e.getStackTrace()));
            }

            try {
                loop = consoleUI.requestContinuation();
            } catch (IOException e) {
                consoleUI.print("Incorrect input");
            }
        }
        log.info("Execution finished");
    }

}
