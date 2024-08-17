package com.azish.multithread;

import java.util.List;
import java.util.concurrent.Callable;

public class ListAdderWithReturn implements Callable<Integer> {

    private final List<Integer> numbers;
    private final String name;

    public ListAdderWithReturn(List<Integer> numbers, String name) {
        this.numbers = numbers;
        this.name = name;
    }

    @Override
    public Integer call() {
        Integer result = this.numbers.stream().reduce(0, (a,b) -> a+b);
        System.out.println(name + " finished : " + result);
        return result;

    }

}
