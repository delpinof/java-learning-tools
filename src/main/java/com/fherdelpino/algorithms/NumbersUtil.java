package com.fherdelpino.algorithms;

import lombok.extern.slf4j.Slf4j;

import java.util.LinkedList;

@Slf4j
public class NumbersUtil {
    public int[] extractNumbers(int n) {
        int number = n + 0;
        LinkedList<Integer> numbers = new LinkedList<>();
        while (number > 0) {
            int lastDigit = number % 10;
            log.debug("digit={}", lastDigit);
            numbers.push(lastDigit);
            number /= 10;
        }
        int[] numbersArray = new int[numbers.size()];
        for (int i = 0; i < numbersArray.length; i++) {
            numbersArray[i] = numbers.removeFirst();
        }
        return numbersArray;
    }
}
