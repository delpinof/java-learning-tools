package com.fherdelpino.concurrency;

import java.util.stream.IntStream;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CountToNTask implements Runnable {
    public static final int N = 1000;

    @Override
    public void run() {
        IntStream.range(0, N).forEach(n -> log.info("{} n: {}", Thread.currentThread().getName(), n));
    }
}
