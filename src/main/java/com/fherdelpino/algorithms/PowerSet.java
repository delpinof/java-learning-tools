package com.fherdelpino.algorithms;

import java.util.ArrayList;
import java.util.Collection;
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

    public List<int[]> bitsRecursive(int[] bits, int i) {
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
    public <T> List<List<T>> powerSet(List<T> elements) {
        return powerSet(elements, new ArrayList<>(), 0);
    }

    private <T> List<List<T>> powerSet(List<T> elements, List<T> subSet, int i) {
        List<List<T>> result;
        if (i == elements.size()) {
            result = new ArrayList<>();
            result.add(subSet);
            return result;
        } else {
            result = powerSet(elements, new ArrayList<>(subSet), i+1);
            subSet.add(elements.get(i));
            result.addAll(powerSet(elements, new ArrayList<>(subSet), i+1));
        }
        return result;
    }

}
