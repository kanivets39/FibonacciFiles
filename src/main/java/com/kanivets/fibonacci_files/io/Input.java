package com.kanivets.fibonacci_files.io;

import java.io.IOException;

/**
 * Input.
 */
public interface Input {

    /**
     * Read string.
     *
     * @return the string
     * @throws IOException the io exception
     */
    String read() throws IOException;

}
