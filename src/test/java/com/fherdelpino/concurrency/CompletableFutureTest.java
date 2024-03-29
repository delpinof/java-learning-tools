package com.fherdelpino.concurrency;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.function.Supplier;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Slf4j
public class CompletableFutureTest {

    @Test
    public void test() {
        ExecutorService executor = Executors.newCachedThreadPool();
        CompletableFuture<String> completableFuture = new CompletableFuture<>();

        executor.submit(() -> {
            Thread.sleep(500);
            completableFuture.complete("Hello");
            log.info("Executor has finished.");
            return null;
        });
        log.info("Test has finished.");
    }

    @Test
    public void test2() throws ExecutionException, InterruptedException {
        Supplier<String> helloSupplier = () -> {
            try {
                log.info("Async Supplier has started");
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "Hello";
        };
        log.info("Starting test");
        CompletableFuture<String> completableFuture
                = CompletableFuture.supplyAsync(helloSupplier);

        CompletableFuture<String> future = completableFuture
                .thenApply(s -> s + " World");

        log.info("doing other things...");

        assertEquals("Hello World", future.get(), "Now we get the future message...");
    }
}
