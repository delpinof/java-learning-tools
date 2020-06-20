package com.fherdelpino.challenge;

public class Fibonacci {

    private static long[] memo = new long[100];

    public static long compute(int n) {
        long result = 0;

        if (n == 1) {
            result = 0;
        } else if (n == 2) {
            result = 1;
        } else {
            result = compute(n - 1) + compute(n - 2);
        }

        return result;
    }

    public static long computeWithMemo(long n) {
        long result = 0;

        if (memo[(int) n] != 0)
            return memo[(int) n];

        if (n == 1) {
            result = 0;
        } else if (n == 2) {
            result = 1;
        } else {
            result = computeWithMemo(n - 1) + computeWithMemo(n - 2);
            memo[(int) n] = result;
        }

        return result;
    }
}
