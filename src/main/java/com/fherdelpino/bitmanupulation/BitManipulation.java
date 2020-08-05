package com.fherdelpino.bitmanupulation;

public class BitManipulation {

    public static boolean getBit(int num, int i) {
        return ((num & (1<<i))!=0);
    }

    public static int setBit(int num, int i) {
        return num | (1<<i);
    }
}
