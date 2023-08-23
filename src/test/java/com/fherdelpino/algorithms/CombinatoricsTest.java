package com.fherdelpino.algorithms;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class CombinatoricsTest {

    @Test
    public void test() {
        List<List<String>> result = Combinatorics.findCombinations(new String[]{"a", "b", "c"}, 2);

        assertThat(result).containsExactlyInAnyOrder(List.of("a", "b"),
                List.of("a", "c"),
                List.of("b", "c"));
    }
}
