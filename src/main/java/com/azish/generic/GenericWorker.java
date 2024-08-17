package com.azish.generic;

import java.math.BigInteger;
import java.util.List;

public class GenericWorker {


    public static Integer bigIntegerSize(String input) {
        CustomList<BigInteger, Integer> list = new CustomList<>(20);
        return list.count(BigInteger.ONE);
    }

    public static String doPrint() {
       StringUtils.<String, Integer,Boolean>print(200,true);
       return StringUtils.<String, Integer,Long>print(200,54L);
    }

//    public static void printListWildCard() {
//        StringUtils.printListWildCard(List.of(1,2));
//    }
}
