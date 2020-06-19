package com.fherdelpino.concurrency;

import java.util.stream.IntStream;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SingleTreadMain {
    public static void main(String[] args) {
        IntStream.range(0,CountToNTask.N).forEach(n -> new Thread(new CountToNTask()).start());
    }
}
