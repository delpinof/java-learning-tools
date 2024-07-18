package com.fherdelpino.mapping;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.stream.Collectors;

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

    @Test
    public void testMapSortByKey() {
        SortedMap<String, Integer> namesMap = new TreeMap<>(String::compareTo);
        namesMap.computeIfAbsent("Fernando", String::length);
        namesMap.computeIfAbsent("Alonso", String::length);
        namesMap.computeIfAbsent("John", String::length);
        namesMap.computeIfAbsent("Jo", String::length);

        log.info("{}", namesMap);
    }

    @Test
    public void testMapSortByValue() {
        Map<String, Integer> namesMap = new HashMap<>();
        namesMap.computeIfAbsent("Fernando", String::length);
        namesMap.computeIfAbsent("Alonso", String::length);
        namesMap.computeIfAbsent("John", String::length);
        namesMap.computeIfAbsent("Jo", String::length);

        LinkedHashMap<String, Integer> sortedMap = namesMap.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .collect(Collectors.toMap(Map.Entry::getKey,
                        Map.Entry::getValue,
                        (o1, o2) -> o1,
                        LinkedHashMap::new));
        for(String s : sortedMap.keySet()) {
            log.info("{}={}", s, sortedMap.get(s));
        }

    }
}
