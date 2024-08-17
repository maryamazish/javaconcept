package com.azish.multithread;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

public class ThreadWorker {

    private final ExecutorService executorService;


    public ThreadWorker(ExecutorService executorService) {
        this.executorService = executorService;
    }


    public Integer sumWithRunnable(List<Integer> numbers) throws InterruptedException {

        final AtomicInteger result = new AtomicInteger();
        int numberOfLists = 10;
        int subListSize = numbers.size() / numberOfLists;
        int index = 0;

        while (index < numbers.size()) {
            int indexTo = Math.min(index + subListSize, numbers.size());
            List<Integer> list = numbers.subList(index, indexTo);
            //runnable
            this.executorService.submit(new ListAdderWithoutReturn(list, result, "part from index : " + index + " ,to : " + indexTo));
            index = indexTo;
        }
        System.out.println("Shutting down");
        this.executorService.shutdown();
        this.executorService.awaitTermination(1, TimeUnit.MINUTES);
        return result.get();
    }

    public Integer sumWithCallable(List<Integer> numbers) throws InterruptedException, ExecutionException {

        int numberOfLists = 10;
        int subListSize = numbers.size() / numberOfLists;
        int index = 0;

        List<Future<Integer>> futures = new ArrayList<>();
        while (index < numbers.size()) {
            int indexTo = Math.min(index + subListSize, numbers.size());
            List<Integer> list = numbers.subList(index, indexTo);
            //runnable
            futures.add(executorService.submit(new ListAdderWithReturn(list, "part from index : " + index + " to : " + indexTo)));
            index = indexTo;
        }
        System.out.println("Shutting down");
        this.executorService.shutdown();
        this.executorService.awaitTermination(1, TimeUnit.MINUTES);
        System.out.println("sum result ... ");
        int result = 0;
        for(Future<Integer> future : futures)
            result += future.get();
        return result;
    }
}
