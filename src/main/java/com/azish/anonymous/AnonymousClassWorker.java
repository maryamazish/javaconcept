package com.azish.anonymous;

import java.util.concurrent.CountDownLatch;

public class AnonymousClassWorker {



    public static Runnable createRunnableWithAnonymousClass(CountDownLatch latch) {
        var runnable = new Runnable() {
            @Override
            public void run() {
                latch.countDown();
            }
        };
        return runnable;
    }

    public static Runnable createRunnableWithAnonymousClass2(CountDownLatch latch) {
        var runnable = new Counter(latch) {

            private final String TEST = "";

            @Override
            public void run() {
                latch.countDown();
                test();
            }

            private void test() {
                System.out.println("latch :: "+latch.getCount());
            }

            class Student {

            }
        };
        return runnable;
    }

    public static Runnable createRunnableWithoutAnonymousClass(CountDownLatch latch) {
        var runnable = new Counter(latch);
        return runnable;
    }


}
