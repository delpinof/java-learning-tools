package com.fherdelpino.bitmanupulation;

import lombok.extern.slf4j.Slf4j;

@Slf4j
class CountSetBit {
    private static int helper(int n) {
        int count = 0;
        int tmp;
        while (n > 0) {
            tmp = n-1;
            log.info("{}({}) - {}({})",n, Integer.toBinaryString(n), tmp, Integer.toBinaryString(tmp));
            n &= tmp;
            count++;
        }
        return count;
    }

    public static void main(String[] args) {
        int number = 125;
        System.out.println("SetBit Count is : " + helper(number));
    }
}
