package com.kanivets.fibonacci_files.service;

/**
 * String reverser based on recursive algorithm.
 */
public class StringReverserImpl implements StringReverser{

    public String reverse(String str){
            if (str.length() <= 1) {
                return str;
            }

            return reverse(str.substring(1)) + str.charAt(0);
    }

}
