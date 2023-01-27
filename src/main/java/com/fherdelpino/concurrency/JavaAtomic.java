package com.fherdelpino.concurrency;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.atomic.AtomicInteger;

@Slf4j
public class JavaAtomic {

    public static void main(String[] args) throws InterruptedException {

        ProcessingThread pt = new ProcessingThread();
        Thread t1 = new Thread(pt, "t1");
        Thread t2 = new Thread(pt, "t2");

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        log.info("Processing count may vary=[{}]", pt.getCount());

        ProcessingThreadAtomic pta = new ProcessingThreadAtomic();
        Thread t1a = new Thread(pta, "t1a");
        Thread t2a = new Thread(pta, "t2a");

        t1a.start();
        t2a.start();

        t1a.join();
        t2a.join();

        log.info("Processing count will not vary=[{}]", pta.getCount());
    }

}

class ProcessingThread implements Runnable {
    private int count;

    @Override
    public void run() {
        for (int i = 1; i < 5; i++) {
            processSomething(i);
            //System.out.println("increasing the count with " + Thread.currentThread().getName());
            count++;
        }
    }

    public int getCount() {
        return this.count;
    }

    private void processSomething(int i) {
        // processing some job
        try {
            Thread.sleep((long) i * 10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}

class ProcessingThreadAtomic implements Runnable {
    private final AtomicInteger count = new AtomicInteger();

    @Override
    public void run() {
        for (int i = 1; i < 5; i++) {
            processSomething(i);
            count.incrementAndGet();
        }
    }

    public int getCount() {
        return this.count.get();
    }

    private void processSomething(int i) {
        // processing some job
        try {
            Thread.sleep((long) i * 10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
