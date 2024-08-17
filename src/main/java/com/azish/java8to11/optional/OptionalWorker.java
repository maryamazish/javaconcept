package com.azish.java8to11.optional;

import java.util.Optional;

public class OptionalWorker {
    public static Integer searchOnArray(Integer[] entryArray, int index){
        Optional<Integer> value = Optional.ofNullable(entryArray[index]);
        if(value.isPresent())
            return entryArray[index];
        return null;
    }

    public static Dimension getDimension(int size) {
        if (size<=0){
            return null;
        }
        return new Dimension(size);
    }

    public static void printDimension(int size) {
        System.out.println("the size is: " + size);
    }

}
