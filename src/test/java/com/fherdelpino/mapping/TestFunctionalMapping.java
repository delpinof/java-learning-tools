package com.fherdelpino.mapping;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;


@Slf4j
public class TestFunctionalMapping {

    @Test
    public void testComputeIfAbsent() {
        Map<String, Integer> namesMap = new HashMap<>();

        namesMap.computeIfAbsent("Fernando", String::length);
        namesMap.computeIfAbsent("del Pino", String::length);

        log.info("{}", namesMap);
        assertThat(namesMap).contains(Map.entry("Fernando", 8), Map.entry("del Pino", 8));
    }
}
