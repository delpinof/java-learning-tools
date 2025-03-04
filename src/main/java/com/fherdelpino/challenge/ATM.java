package com.fherdelpino.challenge;

import java.util.Comparator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class ATM {

    public Map<Integer, Integer> withdraw(Set<Integer> denominations, int amount) {

        // Sort the denominations in descending order
        Set<Integer> denominationsSorted = new TreeSet<>(Comparator.reverseOrder());
        denominationsSorted.addAll(denominations);

        // Create a TreeMap to store the result in descending order
        Map<Integer, Integer> result = new TreeMap<>(Comparator.reverseOrder());

        // Iterate over the denominations and calculate the amount of each denomination
        for (Integer denomination : denominationsSorted) {
            while (amount >= denomination) {
                amount -= denomination;
// Increment the count of each denomination
//                if (!result.containsKey(denomination)) {
//                    result.put(denomination, 1);
//                } else {
//                    Integer previousCount = result.get(denomination);
//                    result.put(denomination, previousCount + 1);
//                }

                // Instead of code above, use the merge method to increment the count of each denomination
                result.merge(denomination, 1, (previousCount, increment) -> previousCount + increment);
            }
        }

        return result;
    }
}
