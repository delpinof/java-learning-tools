package com.fherdelpino.bitmanupulation;

class SingleNumber {
    private static int singleNumber(int[] nums) {
        int xor = 0;
        for (int num : nums) {
            xor ^= num;
        }
        return xor;
    }

    public static void main(String[] args) {
        int[] nums = {7, 15, 9, 7, 15};
        System.out.println("Element appearing one time is " + singleNumber(nums));
    }
}