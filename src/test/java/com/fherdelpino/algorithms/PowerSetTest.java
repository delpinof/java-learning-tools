package com.fherdelpino.algorithms;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.List;

@Slf4j
public class PowerSetTest {

    @Test
    public void testStringBits() {
        PowerSet powerSet = new PowerSet();
        List<List<String>> result = powerSet.powerSet(new String[]{"a", "b", "c"});
        for (List<String> set : result)
            log.info("set={}", set);
    }

    @Test
    public void testBitsRecursive() {
        PowerSet powerSet = new PowerSet();
        List<int[]> result = powerSet.bitsRecursive(new int[3], 0);
        for (int [] bits: result) {
            log.info("bits={}", bits);
        }
    }
}
