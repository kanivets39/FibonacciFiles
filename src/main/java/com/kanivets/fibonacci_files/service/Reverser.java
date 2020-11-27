package com.kanivets.fibonacci_files.service;

import com.kanivets.fibonacci_files.exception.ReverseException;

import java.util.List;

/**
 * The interface Reverser.
 * Can reverse some data structures.
 */
public interface Reverser {

    /**
     * Reverse rows list.
     *
     * @param list           the list to reverse
     * @param stringReverser the string reverser that have
     * @return the reversed list
     * @throws ReverseException the reverse exception
     */
    List<String> reverseListStrings(List<String> list, StringReverser stringReverser) throws ReverseException;

}
