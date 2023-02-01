package com.fherdelpino.challenge;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class PowerOf3EqualsTest {

    private static final int MIN = 1;
    private static final int MAX = 100; //usually 1K
    private int count;

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
    }

    @Test
    public void pairs() {
        final String separator = ":";
        Map<Integer, List<String>> pairs = new HashMap<>();
        for (int c = MIN; c <= MAX; c++) {
            for (int d = MIN; d <= MAX; d++) {
                int key = (int) (Math.pow(c, 3) + Math.pow(d, 3));
                if (!pairs.containsKey(key)) {
                    pairs.put(key, new ArrayList<>());
                }
                pairs.get(key).add(c + separator + d);
            }
        }

        for (int a = MIN; a <= MAX; a++) {
            for (int b = MIN; b <= MAX; b++) {
                int result = (int) (Math.pow(a, 3) + Math.pow(b, 3));
                for (String cdPair : pairs.get(result)) {
                    String[] cdArray = cdPair.split(separator);
                    int c = Integer.parseInt(cdArray[0]);
                    int d = Integer.parseInt(cdArray[1]);
                    log.info("a={}, b={}, c={}, d={}", a, b, c, d);
                    count++;
                }
            }
        }
    }

    @Test
    public void pair() {
        final String separator = ":";
        Map<Integer, List<String>> pairs = new HashMap<>();
        for (int c = MIN; c <= MAX; c++) {
            for (int d = MIN; d <= MAX; d++) {
                int key = (c * c * c) + (d * d * d);
                if (!pairs.containsKey(key)) {
                    pairs.put(key, new ArrayList<>());
                }
                pairs.get(key).add(c + separator + d);
            }
        }
        for (List<String> results : pairs.values()) {
            for (String pair1 : results) {
                for (String pair2 : results) {
                    String[] abArray = pair1.split(separator);
                    String[] cdArray = pair2.split(separator);
                    log.info("a={}, b={}, c={}, d={}",
                        abArray[0],
                        abArray[1],
                        cdArray[0],
                        cdArray[1]
                    );
                    count++;
                }
            }
        }
    }

    @After
    public void tearDown() {
        log.info("total={}", count);
    }
}
