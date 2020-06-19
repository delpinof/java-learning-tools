package com.fherdelpino.concurrency;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class FuturesMain {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        Future<String> future = executorService.submit(() -> {
            Thread.sleep(10000);
            return "Done";
        });

        log.info("getting future...");
        try {
            String val = future.get();
            log.info(val);
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }


    }
}
