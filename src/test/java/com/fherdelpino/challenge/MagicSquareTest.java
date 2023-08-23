package com.fherdelpino.challenge;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@Slf4j
public class MagicSquareTest {

    MagicSquare sut = new MagicSquare();

    @Test
    public void testBuild() {
        int size = 3;
        int[][] magicSquare = sut.build(size);
        printMagicSquare(magicSquare);
        List<Integer> sums = getAllSums(magicSquare);
        int magicNumber = (size * size * size + size) / 2;
        assertThat(sums).allMatch(element -> element.equals(magicNumber), String.format("All sums match %s", magicNumber));
    }

    private List<Integer> getAllSums(int[][] magicSquare) {
        int size = magicSquare.length;
        int diagSum = 0;
        int backDiagSum = 0;
        List<Integer> sums = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            int rowSum = 0;
            int colSum = 0;
            for (int j = 0; j < size; j++) {
                rowSum += magicSquare[i][j];
                colSum += magicSquare[j][i];
            }
            sums.add(rowSum);
            sums.add(colSum);
            diagSum += magicSquare[i][i];
            backDiagSum += magicSquare[i][size - i - 1];
        }
        sums.add(diagSum);
        sums.add(backDiagSum);
        return sums;
    }

    @Test
    public void testBuildAllMagicSquares() {
        int size = 3;
        int magicNumber = (size * size * size + size) / 2;
        int[][][] magicSquares = sut.buildAllMagicSquares(size);
        for (var magicSquare : magicSquares) {
            printMagicSquare(magicSquare);
            List<Integer> sums = getAllSums(magicSquare);
            assertThat(sums).allMatch(element -> element.equals(magicNumber), String.format("All sums match %s", magicNumber));
            log.info("---------");
        }
    }

    private void printMagicSquare(int[][] magicSquare) {
        for (int[] row : magicSquare) {
            log.info("{}", row);
        }
    }
}
