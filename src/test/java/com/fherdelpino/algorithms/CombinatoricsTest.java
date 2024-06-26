package com.fherdelpino.algorithms;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@Slf4j
public class CombinatoricsTest {

    @Test
    public void test() {
        List<List<String>> result = Combinatorics.findCombinations(new String[]{"a", "b", "c"}, 2);

        assertThat(result).containsExactlyInAnyOrder(List.of("a", "b"),
                List.of("a", "c"),
                List.of("b", "c"));
    }

    @Test
    public void testAllSubLists() {
        List<Integer> numbers = List.of(1, 2, 3);
        List<List<Integer>> result = Combinatorics.getAllSubList(numbers);
        log.info("{}", result);
    }

    @Test
    public void testSums() {
        List<Integer> numbers = List.of(1, 2, 3, 4);
        List<Integer> sums = Combinatorics.getAllSubListsSums1(numbers);
        log.info("{}", sums);
    }

    @Test
    public void testPrefixSum() {
        List<Integer> numbers = List.of(1, 2, 3, 4);
        List<Integer> prefixSum = Combinatorics.getPrefixSum(numbers);
        log.info("{}", prefixSum);
    }

    @Test
    public void testAllSumsWithPrefixSumAlgorithm() {
        List<Integer> numbers = List.of(1, 2, 3);
        List<Integer> sums1 = Combinatorics.getAllSubListsSums1(numbers);
        List<Integer> sums2 = Combinatorics.getAllSubListSums2(numbers);
        assertThat(sums2).containsAll(sums1);
        log.info("{}", sums2);
    }
}
