package com.fherdelpino.test.challenge;

import com.fherdelpino.challenge.ReverseNumber;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ReverseNumberTest {

    @Test
    public void reverseNumberTest() {
        int n = 654;
        int result = ReverseNumber.reverse(n);
        assertEquals(456, result);
    }
}
