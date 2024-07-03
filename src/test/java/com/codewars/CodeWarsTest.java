package com.codewars;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CodeWarsTest {

    @Test
    public void sampleTests() {
        assertArrayEquals(new int[]{2}, Kata.arrayDiff(new int[]{1, 2}, new int[]{1}));
        assertArrayEquals(new int[]{2, 2}, Kata.arrayDiff(new int[]{1, 2, 2}, new int[]{1}));
        assertArrayEquals(new int[]{1}, Kata.arrayDiff(new int[]{1, 2, 2}, new int[]{2}));
        assertArrayEquals(new int[]{1, 2, 2}, Kata.arrayDiff(new int[]{1, 2, 2}, new int[]{}));
        assertArrayEquals(new int[]{}, Kata.arrayDiff(new int[]{}, new int[]{1, 2}));
    }

    @Test
    public void FixedTests() {
        assertEquals("Ths wbst s fr lsrs LL!", Troll.disemvowel("This website is for losers LOL!")
        );
        assertEquals("N ffns bt,\nYr wrtng s mng th wrst 'v vr rd", Troll.disemvowel(
                "No offense but,\nYour writing is among the worst I've ever read"));
        assertEquals("Wht r y,  cmmnst?", Troll.disemvowel("What are you, a communist?"));
    }

    @Test
    void findParity() {
        assertEquals(3, FindOutlier.find(new int[]{2, 6, 8, -10, 3}));
        assertEquals(206847684, FindOutlier.find(new int[]{206847684, 1056521, 7, 17, 1901, 21104421, 7, 1, 35521, 1, 7781}));
        assertEquals(0, FindOutlier.find(new int[]{Integer.MAX_VALUE, 0, 1}));
    }

    @ParameterizedTest
    @MethodSource
    public void testList(int[] numbers, boolean expectedResult) {
        expectedResult = FindOutlier.isMostlyOdd(numbers);
    }

    public static Stream<Arguments> testList() {
        return Stream.of(
                Arguments.of(new int[]{1, 3, 5}, true),
                Arguments.of(new int[]{1, 3, 6}, true),
                Arguments.of(new int[]{1, 2, 6}, false),
                Arguments.of(new int[]{2, 4, 6}, false)
        );
    }
}
