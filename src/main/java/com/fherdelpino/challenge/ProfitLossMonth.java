package com.fherdelpino.challenge;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class ProfitLossMonth {

    public static int getMonthsLoss(List<Integer> profits) {
        return backtrack(profits, 0, 0);
    }

    private static int backtrack(List<Integer> profits, int i, int sum) {
        if (i == profits.size()) {
            return 0;
        }
        int resultN = 0;
        if (sum > profits.get(i)) {
            resultN = 1 + backtrack(profits, i + 1, sum - profits.get(i));
        }
        int resultP = backtrack(profits, i + 1, sum + profits.get(i));
        return Math.max(resultN, resultP);
    }

    public static int backTrack2(List<Integer> profits) {
        var result = backtrack2(profits, 0, 0, new int[profits.size()]);
        int maxCount = 0;
        for (int[] possible : result) {
            int currentCount = 0;
            for (int n : possible) {
                if (n < 0) {
                    currentCount++;
                }
            }
            if (currentCount > maxCount) {
                maxCount = currentCount;
            }
        }
        return maxCount;
    }

    private static List<int[]> backtrack2(List<Integer> profits, int i, int sum, int[] possible) {
        if (i == profits.size()) {
            return List.of(possible.clone());
        }
        List<int[]> result = new ArrayList<>();
        if (sum - profits.get(i) > 0) {
            possible[i] = profits.get(i) * -1;
            result.addAll(backtrack2(profits, i + 1, sum - profits.get(i), possible));
        }
        possible[i] = profits.get(i);
        result.addAll(backtrack2(profits, i + 1, sum + profits.get(i), possible));
        return result;
    }
}
