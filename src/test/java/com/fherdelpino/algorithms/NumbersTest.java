package com.fherdelpino.algorithms;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class NumbersTest {

    private NumbersUtil numbersUtil;

    @BeforeEach
    public void setUp() {
        numbersUtil = new NumbersUtil();
    }

    @Test
    public void testExtractNumber() {
        int[] expectedResult = {4, 5, 6, 7};
        int input = 4567;
        int[] actualResult = numbersUtil.extractNumbers(input);
        assertThat(actualResult).isEqualTo(expectedResult);
    }

    @Test
    public void testJoinNumber() {
        int[] input = {4, 5, 6, 7};
        int expectedResult = 4567;
        int actualResult = numbersUtil.joinNumbers(input);
        assertThat(actualResult).isEqualTo(expectedResult);
    }

}
