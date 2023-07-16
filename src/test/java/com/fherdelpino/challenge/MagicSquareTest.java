package com.fherdelpino.challenge;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@Slf4j
public class MagicSquareTest {

    MagicSquare sut = new MagicSquare();

    @Test
    public void test() {
        int size = 3;
        int[][] magicSquare = sut.build(size);
        for (int[] row : magicSquare) {
            log.info("{}", row);
        }

        int rowSum = 0;
        int colSum = 0;
        List<Integer> sums = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                rowSum += magicSquare[i][j];
                colSum += magicSquare[j][i];
            }
            sums.add(rowSum);
            sums.add(colSum);
            rowSum = 0;
            colSum = 0;
        }
        int sum = sums.get(0);
        assertThat(sums).allMatch(element -> element.equals(sum));
        log.info("All sums match {}", sum);
    }
}
