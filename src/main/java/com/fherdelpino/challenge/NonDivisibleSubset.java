package com.fherdelpino.challenge;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class NonDivisibleSubset {

    /*
    Given a set of distinct integers, print the size of a maximal subset of  where the sum of any numbers in s is not evenly divisible by k.
     */
    public static int find(int k, List<Integer> s) {
        int[] remainer = new int[k];
        for(int n : s){
            remainer[n % k]++;
        }

        int res = (remainer[0] > 0) ? 1 : 0;

        if(k % 2 == 0){
            res += (remainer[k / 2] > 0) ? 1 : 0;
        }

        for(int i = 1; i <= (k-1)/2 ; i++){
            res += Math.max(remainer[i], remainer[k-i]);
        }

        return res;
    }

}
