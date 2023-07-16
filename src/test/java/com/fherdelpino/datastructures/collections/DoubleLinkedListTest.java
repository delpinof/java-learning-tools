package com.fherdelpino.datastructures.collections;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;

@Slf4j
public class DoubleLinkedListTest {

    DoubleLinkedList dll = new DoubleLinkedList();

    @Test
    public void testGetValues() {
        String testString = "ABCD";
        dll.insertWord(testString);
        assertThat(dll.getValues()).isEqualTo(testString);
    }

    @Test
    public void testGetValuesReversed() {
        StringBuilder testString = new StringBuilder("ABCD");
        dll.insertWord(testString.toString());
        assertThat(dll.getValuesReversed()).isEqualTo(testString.reverse().toString());
    }

    @Test
    public void testRemove() {
        dll.insertWord("AAWSWS");
        assertThat(dll.remove("AWS")).isEqualTo("");
    }

    @Test
    public void mapTest() {
        Map<String, Integer> lettersMap = new HashMap<>();
        for (var letter : "ABCAC".split("")) {
            lettersMap.merge(letter, 1, Integer::sum);
        }
        assertThat(lettersMap).containsAllEntriesOf(Map.of("A", 2, "B", 1, "C", 2));
    }

    @Test
    public void mapMerge() {
        Map<String, List<Integer>> lettersMap = new HashMap<>();
        String[] genes = "TGATGCCGTCCCCTCAACTTGAGTGCTCCTAATGCGTTGC".split("");
        int nExpected = genes.length/4;
        List<String> excess = new ArrayList<>();
        for (int i = 0; i < genes.length; i++) {
            lettersMap.putIfAbsent(genes[i], new ArrayList<>());
            lettersMap.get(genes[i]).add(i);
            if (lettersMap.get(genes[i]).size() > nExpected) {
                excess.add(genes[i]);
            }
        }
        lettersMap.forEach((k,v) -> System.out.println(k +": " + v.size()));
        log.info("{}",excess);
    }

    @Test
    public void getAllSubstrings() {
        String s = "ABCDE";
        List<String> substrings = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j <= s.length(); j++) {
                substrings.add(s.substring(i, j));
            }
        }
        int expectedSize = IntStream.rangeClosed(1, s.length())
                .reduce(Integer::sum)
                .orElse(0);
        log.info("originalSize={} " +
                "resultSize={} " +
                "expectedSize={}", s.length(), substrings.size(), expectedSize);
        log.info("{}", substrings);
    }

    @Test
    public void testXor() {
        int[] numbers = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        int count = 1;
        for (int number : numbers) {
            for (int i : numbers) {
                int xor = number ^ i;
                int and = number & i;
                log.info("{} -> {}:{} = xor:{} | and:{} ... {}", count++, number, i, xor, and, xor < and);
            }
        }

    }

    @Test
    public void testAnd() {
        assertThat(2 & 3).isEqualTo(3 & 2);
    }

}
