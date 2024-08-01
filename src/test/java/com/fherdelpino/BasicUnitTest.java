package com.fherdelpino;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

@Slf4j
public class BasicUnitTest {
    @Test
    public void test() {
        log.info("event=RunningUnitTests");
    }

    @ParameterizedTest
    @MethodSource
    public void test2(String pattern, String s, boolean expectedOutput) {
        boolean result = wordPattern(pattern, s);
        assertThat(result).isEqualTo(expectedOutput);
    }

    public static Stream<Arguments> test2() {
        return Stream.of(
                Arguments.of("abba", "dog cat cat dog", true),
                Arguments.of("abba", "dog dog dog dog", false),
                Arguments.of("abc", "b c a", true),
                Arguments.of("aaa", "aa aa aa aa", false)
        );
    }

    public boolean wordPattern(String pattern, String s) {
        Map<Character, String> mapC = new HashMap<>();
        String[] words = s.split(" ");
        if (words.length != pattern.length()) {
            return false;
        }
        for (int i = 0; i < pattern.length(); i++) {
            Character c = pattern.charAt(i);
            String word = words[i];
            if (mapC.containsKey(c)) {
                if (!word.equals(mapC.get(c))) {
                    return false;
                }
            } else {
                if (mapC.containsValue(word)) {
                    return false;
                }
                mapC.put(c, word);
            }
        }
        return true;
    }

    @Test
    public void test3() {
        evalRPN(new String[]{"2", "1", "+", "3", "*"});
    }

    public int evalRPN(String[] tokens) {
        Deque<Integer> deque = new LinkedList<>();
        for (String token : tokens) {
            BiFunction<Integer, Integer, Integer> f = null;
            if ("+".equals(token)) {
                f = (a, b) -> a + b;
            } else if ("-".equals(token)) {
                f = (a, b) -> b - a;
            } else if ("*".equals(token)) {
                f = (a, b) -> a * b;
            } else if ("/".equals(token)) {
                f = (a, b) -> b / a;
            }

            if (f == null) {
                deque.offerFirst(Integer.parseInt(token));
            } else {
                deque.offerFirst(f.apply(deque.pollFirst(), deque.pollFirst()));
            }
        }

        return deque.pollFirst();
    }

    @ParameterizedTest
    @MethodSource
    public void test4(int[][] m) {
        rotate(m);
    }

    public static Stream<Arguments> test4() {
        return Stream.of(
                Arguments.of((Object) createMatrix(3)),
                Arguments.of((Object) createMatrix(10)),
                Arguments.of((Object) createMatrix(100)),
                Arguments.of((Object) createMatrix(1000)),
                Arguments.of((Object) createMatrix(10000))
        );
    }

    private static int[][] createMatrix(int n) {
        int count = 1;
        int[][] m = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                m[i][j] = count++;
            }
        }
        return m;
    }

    public void rotate(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n - 1 - i; j++) {
                swap(matrix, i, j, n - 1 - j, i);
                swap(matrix, n - 1 - j, i, n - 1 - i, n - 1 - j);
                swap(matrix, n - 1 - i, n - 1 - j, j, n - 1 - i);
            }
        }
    }

    private void swap(int[][] m, int sourceRow, int sourceCol, int destRow, int destCol) {
        int tmp = m[destRow][destCol];
        m[destRow][destCol] = m[sourceRow][sourceCol];
        m[sourceRow][sourceCol] = tmp;
    }
}
