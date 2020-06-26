package com.fherdelpino.test.challenge;

import org.junit.Before;
import org.junit.Test;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class PowerOf3Equals {

    private static final int MIN = 1;
    private static final int MAX = 100;
    private int count = 0;

    @Before
    public void setUp() {
        count = 0;
    }

    @Test
    public void bruteForce() {
        for (int a = MIN; a <= MAX; a++) {
            for (int b = MIN; b <= MAX; b++) {
                for (int c = MIN; c <= MAX; c++) {
                    for (int d = MIN; d <= MAX; d++) {
                        if (Math.pow(a, 3) + Math.pow(b, 3) == Math.pow(c, 3) + Math.pow(d, 3)) {
                            log.info("a={}, b={}, c={}, d={}", a, b, c, d);
                            count++;
                        }
                    }
                }
            }
        }
        log.info("total={}", count);
    }

    @Test
    public void breakD() {
        for (int a = MIN; a <= MAX; a++) {
            for (int b = MIN; b <= MAX; b++) {
                for (int c = MIN; c <= MAX; c++) {
                    for (int d = MIN; d <= MAX; d++) {
                        if (Math.pow(a, 3) + Math.pow(b, 3) == Math.pow(c, 3) + Math.pow(d, 3)) {
                            log.info("a={}, b={}, c={}, d={}", a, b, c, d);
                            count++;
                            break;
                        }
                    }
                }
            }
        }
        log.info("total={}", count);
    }

    @Test
    public void avoidD() {
        for (int a = MIN; a <= MAX; a++) {
            for (int b = MIN; b <= MAX; b++) {
                for (int c = MIN; c <= MAX; c++) {
                    int aE = (int) Math.pow(a, 3);
                    int bE = (int) Math.pow(b, 3);
                    int cE = (int) Math.pow(c, 3);
                    int d = (int) Math.cbrt(aE + bE - cE);
                    if (d > 0 && d <= MAX && aE + bE == cE + Math.pow(d, 3)) {
                        log.info("a={}, b={}, c={}, d={}", a, b, c, d);
                        count++;
                    }
                }
            }
        }
        log.info("total={}", count);
    }
}
