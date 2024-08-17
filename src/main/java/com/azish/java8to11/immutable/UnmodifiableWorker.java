package com.azish.java8to11.immutable;

import java.util.*;

public class UnmodifiableWorker {

    //convert modifiable list to unmodifiable list
    public static List<Dimension> toUnmodifiableList(List<Dimension> entryList){
        return Collections.unmodifiableList(entryList);
    }

    public static List<Dimension> toImmutableList(List<Dimension> entryList){
        return List.copyOf(entryList);
    }

}
