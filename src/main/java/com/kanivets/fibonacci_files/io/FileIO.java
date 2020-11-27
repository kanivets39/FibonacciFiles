package com.kanivets.fibonacci_files.io;

import java.io.IOException;
import java.util.List;

/**
 * The interface File Input/Output.
 */
public interface FileIO {

     /**
      * Read list from file.
      *
      * @param path the path
      * @return the list read from file
      * @throws IOException the io exception
      */
     List<String> read(String path) throws IOException;

     /**
      * Write list into file.
      *
      * @param path the file path
      * @param list the list to write
      * @throws IOException the io exception
      */
     void write(String path, List<String> list) throws IOException;

}
