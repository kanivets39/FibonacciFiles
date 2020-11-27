package com.kanivets.fibonacci_files.io;

import java.io.IOException;

/**
 * Console user interface.
 */
public class ConsoleUI {

    private final ConsoleIO consoleIO;

    /**
     * Instantiates a new Console user interface.
     *
     * @param consoleIO the console user interface
     */
    public ConsoleUI(ConsoleIO consoleIO) {
        this.consoleIO = consoleIO;
    }


    public String inputFilePath(String destination) throws IOException {
        print("Enter the path to the file to " + destination);
        return read();
    }

    /**
     * Continue or not action boolean.
     *
     * @return the boolean
     * @throws IOException the io exception
     */
    public boolean requestContinuation() throws IOException {
        print("Do you want to continue working?(y/yes)");
        String answer = read();

        return (answer.compareToIgnoreCase("y") == 0) || (answer.compareToIgnoreCase("yes") == 0);
    }

    /**
     * Print string.
     *
     * @param string the string to print
     */
    public void print(String string) {
        consoleIO.write(string);
    }

    /**
     * Read string.
     *
     * @return read string
     * @throws IOException the io exception
     */
    public String read() throws IOException {
        return consoleIO.read();
    }

}
