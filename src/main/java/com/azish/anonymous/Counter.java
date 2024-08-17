package com.azish.anonymous;

import java.util.concurrent.CountDownLatch;

public class Counter implements Runnable{

    private final CountDownLatch latch;

    public Counter(CountDownLatch latch) {
        this.latch = latch;
    }

    @Override
    public void run() {
        this.latch.countDown();
    }
}
