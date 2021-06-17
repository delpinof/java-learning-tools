package com.fherdelpino.test.concurrency;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.function.Supplier;

import static org.junit.Assert.assertEquals;

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
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "hello";
        };
        CompletableFuture<String> completableFuture
                = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "Hello";
        });

        CompletableFuture<String> future = completableFuture
                .thenApply(s -> s + " World");

        assertEquals("Hello World", future.get());
    }
}
