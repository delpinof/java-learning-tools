package com.fherdelpino.algorithms;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class XorVsAnd {

    public static int countXorGreatThanAnd(int[] numbers) {
        int functionCount = 0;
        int operationCount = 1;
        for (int i = 0; i < numbers.length - 1; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                int xor = numbers[i] ^ numbers[j];
                int and = numbers[i] & numbers[j];
                if (xor > and) {
                    functionCount++;
                } else {
                    log.info("{} -> {}:{} = xor:{} | and:{}", operationCount, numbers[i], numbers[j], xor, and);
                }
                operationCount++;
            }
        }
        return functionCount;
    }

}
