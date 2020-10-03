package com.fherdelpino.algorithms;

import java.util.ArrayList;
import java.util.List;

public class PowerSet {

    public List<List<String>> powerSet(String[] letters) {
        int[] bitArray = new int[letters.length];
        List<int[]> powerSetBit = bitsRecursive(bitArray, 0);
        List<List<String>> powerSet = new ArrayList<>();
        for (int[] bits : powerSetBit) {
            List<String> set = new ArrayList<>();
            for (int i = 0; i < bits.length; i++) {
                if (bits[i] == 1) {
                    set.add(letters[i]);
                }
            }
            powerSet.add(set);
        }
        return powerSet;
    }

    private List<int[]> bitsRecursive(int[] bits, int i) {
        List<int[]> list;
        if (i == bits.length) {
            list = new ArrayList<>();
            list.add(bits.clone());
            return list;
        } else {
            bits[i] = 0;
            list = bitsRecursive(bits, i + 1);
            bits[i] = 1;
            list.addAll(bitsRecursive(bits, i + 1));
        }
        return list;
    }
}
