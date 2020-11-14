package com.fherdelpino.challenge;

public class ReverseNumber {

    public static int reverse(int n) {
        int result = 0;
        while (n != 0) {
            result *= 10;
            result += n % 10;
            n /= 10;
        }
        return result;
    }
}
