package com.fherdelpino.challenge;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

@Slf4j
public class ProfitLossMonthTest {

    @ParameterizedTest
    @MethodSource
    public void test(List<Integer> profits, int expected) {
        var time = System.currentTimeMillis();
        var result1 = ProfitLossMonth.getMonthsLoss(profits);
        var time1 = System.currentTimeMillis() - time;
        time = System.currentTimeMillis();
        var result2 = ProfitLossMonth.backTrack2(profits);
        var time2 = System.currentTimeMillis() - time;
        log.info("{}ms vs {}ms", time1, time2);
        assertThat(result1).isEqualTo(result2);
    }

    public static Stream<Arguments> test() {
        return Stream.of(
                Arguments.of(List.of(5,2,3,5,2,3), 3),
                Arguments.of(List.of(1,1,1,1,1), 2),
                Arguments.of(List.of(6,4,6,8,5,3,2,8,9,4,3,2,4,5,6,7,8,2,1,2,3,4,5,6,4,3,2), 2)
        );
    }
}
