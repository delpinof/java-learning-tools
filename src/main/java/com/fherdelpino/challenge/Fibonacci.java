package com.fherdelpino.challenge;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Fibonacci {

    private static long[] memo = new long[100];

    private static long count = 1;

    public static long compute(int n) {
        long result = 0;

        count++;

        switch (n) {
            case 1:
                result = 0;
                break;
            case 2:
                result = 1;
                break;
            default:
                result = compute(n - 1) + compute(n - 2);
        }

        return result;
    }

    public static long computeWithMemo(int n) {
        long result = 0;

        log.debug("n={}, calls={}", n, count++);

        if (memo[n] != 0)
            return memo[n];

        switch (n) {
            case 1:
                result = 0;
                break;
            case 2:
                result = 1;
                break;
            default:
                result = computeWithMemo(n - 1) + computeWithMemo(n - 2);
                memo[n] = result;
        }

        return result;
    }

    public static long getCount() {
        return count;
    }
}
