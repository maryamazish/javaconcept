package com.azish.java8to11.immutable;

import java.util.*;

public class ImmutableWorker {
    public static List<String> createList(){
        return List.of("Maryam","setayesh","neda","sara");
    }

    public static Set<String> createSet(){
        return Set.of("Maryam","setayesh","neda","sara");
    }

    public static Map<String,Integer> createMap(){
        return Map.of("Maryam",70,"setayesh",75,"neda",80,"sara",65);
    }

    //convert mutable list to immutable list
    public static List<Integer> toImmutableList(List<Integer> entryList){
        return List.copyOf(entryList);
    }

    public static Set<Integer> toImmutableSet(Set<Integer> entrySet){
        return Set.copyOf(entrySet);
    }

}
