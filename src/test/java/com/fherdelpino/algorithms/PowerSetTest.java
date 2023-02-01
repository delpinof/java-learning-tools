package com.fherdelpino.algorithms;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

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
}
