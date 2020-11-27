package com.kanivets.fibonacci_files.service;

import org.junit.Assert;
import org.junit.Test;

public class StringReverserImplTest {

    StringReverserImpl stringReverserImpl = new StringReverserImpl();
    String unreversed = "1234567890";
    String reversed = "0987654321";

    @Test
    public void reverse() {
        String test = stringReverserImpl.reverse(unreversed);
        Assert.assertEquals(reversed, test);
    }

}