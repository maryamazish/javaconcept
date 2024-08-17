package com.azish.java8to11.string;

import java.util.List;

public class StringJoin {

    public static String concatPlus(List<String> tokens) {
        String result = "";
        for (String st : tokens) {
            result += st;
        }
        return result;
    }

    public static String concatJoin(List<String> tokens) {
        return String.join("", tokens);
    }


    public static String concatStringBuilder(List<String> tokens) {
        StringBuilder stringBuilder = new StringBuilder();
        for (String st : tokens)
            stringBuilder.append(st);
        return stringBuilder.toString();
    }

}
