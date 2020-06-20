package com.fherdelpino.challenge;

import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;

@Slf4j
public class Fibonacci {

    private static HashMap<Integer, Long> memo = new HashMap<>();

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

        if (memo.containsKey(n))
            return memo.get(n);

        switch (n) {
            case 1:
                result = 0;
                break;
            case 2:
                result = 1;
                break;
            default:
                result = computeWithMemo(n - 1) + computeWithMemo(n - 2);
                memo.put(n, result);
        }

        return result;
    }

    public static long getCount() {
        return count;
    }
}
