package com.fherdelpino.challenge;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class ATMTest {

    private ATM atm = new ATM();

    @ParameterizedTest
    @MethodSource
    public void testWithdraw(String denominations, String withdraw, Map<Integer, Integer> expectedResult) {
        Set<Integer> denominationsSet = Arrays.stream(denominations.split(","))
                .map(Integer::parseInt)
                .collect(Collectors.toUnmodifiableSet());
        int amount = Integer.parseInt(withdraw);

        Map<Integer, Integer> actualResult = atm.withdraw(denominationsSet, amount);

        assertThat(actualResult).isEqualTo(expectedResult);
    }

    public static Stream<Arguments> testWithdraw() {
        return Stream.of(
                Arguments.of("10,20,50", "140", Map.of(50, 2, 20, 2)),
                Arguments.of("50,20,10", "150", Map.of(50, 3))
        );
    }
}
