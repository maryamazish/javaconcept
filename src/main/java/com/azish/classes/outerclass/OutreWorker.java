package com.azish.classes.outerclass;

import java.util.function.BiFunction;

public class OutreWorker {

    //static inner(nested) class
    public static class StaticInnerClass {

        //static method
        public static int cubeStatic(int num) {
            return num*num;
        }

        //nonstatic method
        public int cubeNonStatic(int num) {
            return num*num;
        }

    }

    //Inner(nested) Classes
    public class innerClass {
        public Integer plus(int a , int b) {
            BiFunction<Integer, Integer,Integer> biFunction = Integer::sum;
            return biFunction.apply(a,b);
        }
    }

}
