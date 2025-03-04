package com.fherdelpino.challenge;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static org.assertj.core.api.Assertions.assertThat;

class AmazonChallengeTest {

    private static final Random r = new Random();

    private static final int START_CHAR = 'A';
    private static final int END_CHAR = 'Z';
    @Test
    public void test() {
        List<String> testData = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i<=1000;i++) {
            sb.append("T");
            sb.append(i);
            sb.append("-");
            sb.append("C");
            sb.append(i%10);
            sb.append("-");
            sb.append(getRandomLetter());
            testData.add(sb.toString());
            sb = new StringBuilder();
        }
        String[] result = AmazonChallenge.get3Pages(testData);
        assertThat(result).containsExactly("A", "B", "C");
    }

    private String getRandomLetter() {
        int randomInt = r.nextInt(END_CHAR-START_CHAR+1);
        char c = (char) (START_CHAR+randomInt);
        return String.valueOf(c);
    }
}