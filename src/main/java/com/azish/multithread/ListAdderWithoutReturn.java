package com.azish.multithread;


import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class ListAdderWithoutReturn implements Runnable{
    private final List<Integer> numbers;
    private final AtomicInteger result;
    private final String name;

    public ListAdderWithoutReturn(List<Integer> numbers, AtomicInteger result, String name) {
        this.numbers = numbers;
        this.result = result;
        this.name = name;
    }

    @Override
    public void run() {
        this.numbers.forEach(this.result::addAndGet);
        System.out.println(name + " finished");
    }
}
