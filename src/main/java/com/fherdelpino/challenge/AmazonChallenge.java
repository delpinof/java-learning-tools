package com.fherdelpino.challenge;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AmazonChallenge {
    /**
     * Given a list of pages visited, return the most common sequence.
     * T1-C1-A
     * T2-C1-B
     * T3-C2-A
     * T4-C2-B
     * T5-C2-C
     * T6-C1-C
     * T7-C1-D
     * where C1 visited A,B,C,D and c2 visited A,B,C
     * the most common 3 pages sequence is A,B,C
     *
     * @return
     */
    public static String[] get3Pages(List<String> pagesVisited) {
        Map<String, List<String>> mapVisited = getMapVisited(pagesVisited);
        Map<String, List<String>> map3PageVisited = getMap3PageVisited(mapVisited);
        Map<String, Integer> mapCount = getMapCount(map3PageVisited);
        String sequence = null;
        int count = 0;
        for (String key : mapCount.keySet()) {
            if (mapCount.get(key) > count) {
                count = mapCount.get(key);
                sequence = key;
            }
        }
        return sequence.split("");
    }

    private static Map<String, Integer> getMapCount(Map<String, List<String>> map3PageVisited) {
        Map<String, Integer> mapCount = new HashMap<>();
        for (List<String> pageVisited : map3PageVisited.values()) {
            pageVisited.forEach(aVisited -> {
                mapCount.merge(aVisited, 1, Integer::sum);
            });
        }
        return mapCount;
    }


    private static Map<String, List<String>> getMap3PageVisited(Map<String, List<String>> mapVisited) {
        Map<String, List<String>> result = new HashMap<>();
        for (String customer : mapVisited.keySet()) {
            List<String> pagesVisited = mapVisited.get(customer);
            result.put(customer, get3PagesVisited(pagesVisited));
        }
        return result;
    }

    private static List<String> get3PagesVisited(List<String> visitedPages) {
        int arraySize = 3;
        List<String> result = new ArrayList<>();
        for (int i = 0; i <= visitedPages.size() - arraySize; i++) {
            result.add(visitedPages.get(i) + visitedPages.get(i + 1) + visitedPages.get(i + 2));
        }
        return result;
    }

    private static Map<String, List<String>> getMapVisited(List<String> pagesVisited) {
        Map<String, List<String>> map = new HashMap<>();
        for (String visited : pagesVisited) {
            String[] arrayVisited = visited.split("-");
            if (!map.containsKey(arrayVisited[1])) {
                map.put(arrayVisited[1], new ArrayList<>());
            }
            map.get(arrayVisited[1]).add(arrayVisited[2]);
        }
        return map;
    }


}
