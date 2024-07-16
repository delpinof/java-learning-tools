package com.fherdelpino.challenge;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class CutTreesTest {

    @Test
    public void test() {
        List<Integer> result = CutTrees.cutTheSticks(List.of(5, 4, 4, 2, 2, 8));
        assertThat(result).containsExactly(6, 4, 2, 1);
    }
}
