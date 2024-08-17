package com.azish.multithread;

import org.junit.jupiter.api.Test;


import java.util.Collections;
import java.util.List;
import java.util.ArrayList;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;


import static org.junit.jupiter.api.Assertions.assertEquals;

public class ThreadWorkerTest {
    @Test
    void sumWithRunnable_success() throws InterruptedException {
        List<Integer> list = Collections.nCopies(1000, 1);
        var executor = Executors.newFixedThreadPool(11);
        ThreadWorker threadWorker = new ThreadWorker(executor);
        Integer result = threadWorker.sumWithRunnable(list);


        assertEquals(1000,result);
    }


    @Test
    void sumWithCallable_success() throws InterruptedException, ExecutionException {
        List<Integer> list = Collections.nCopies(1000, 1);
        var executor = Executors.newFixedThreadPool(11);
        ThreadWorker threadWorker = new ThreadWorker(executor);
        Integer result = threadWorker.sumWithCallable(list);


        assertEquals(1000,result);
    }

}
