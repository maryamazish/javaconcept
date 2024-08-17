package com.azish.java8to11.immutable;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class ImmutableWorkerTest {
    @Test
    void createList_Success(){
        List<String> stringList = ImmutableWorker.createList();
        assertThrows(UnsupportedOperationException.class,()->stringList.add("test"));
    }

    @Test
    void createSet_Success(){
        Set<String> stringSet = ImmutableWorker.createSet();
        assertThrows(UnsupportedOperationException.class,()->stringSet.add("test"));
    }

    @Test
    void createMap_Success(){
        var stringMap = ImmutableWorker.createMap();
        assertThrows(UnsupportedOperationException.class,()->stringMap.put("test",20));
    }

    @Test
    void toImmutableList_Success(){
        List<Integer> numberList = ImmutableWorker.toImmutableList(Arrays.asList(1,2,3,4));
        assertThrows(UnsupportedOperationException.class,()->numberList.add(5));
    }

    @Test
    void toImmutableSet_Success(){
        Set<Integer> numberSet = ImmutableWorker.toImmutableSet(new HashSet<>(Arrays.asList(1,2,3,4)));
        assertThrows(UnsupportedOperationException.class,()->numberSet.add(5));
    }
}
