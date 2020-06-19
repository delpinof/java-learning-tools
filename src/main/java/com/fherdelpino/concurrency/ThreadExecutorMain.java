package com.fherdelpino.concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ThreadExecutorMain {

    public static void main(String[] args) {
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        log.info("available Processors: {}", availableProcessors);
//        ExecutorService executorService = Executors.newFixedThreadPool(availableProcessors);
//        executorService.shutdown();
    }
}
