package com.fherdelpino.test.collections.sort;

import com.fherdelpino.collections.sort.BubbleSort;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.Random;

@Slf4j
public class BubbleSortTest {

    @Test
    public void test10Integers() {
        int[] testData = {9, 8, 7, 6, 5, 4, 3, 2, 1, 0};
        BubbleSort bubbleSort = new BubbleSort();

        int[] result = bubbleSort.sort(testData);

        log.info("result={}", result);

    }

    @Test
    public void test100Integers() {
        Random random = new Random();
        int total = 100;
        int[] testData = new int[total];
        for(int i = 0; i<total;i++){
            testData[i] = random.nextInt(total);
        }
        BubbleSort bubbleSort = new BubbleSort();

        int[] result = bubbleSort.sort(testData);

        log.info("result={}", result);

    }
}
