package com.azish.programmingexercise.pattern;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class PascalTriangle {
    public static void draw(Integer num) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < num; i++) {
            if (list.size() == 0)
                list.add(1);
            else if (list.size() == 1) {
                list.add(1);
            } else {
                List<Integer> newList = new ArrayList<>();
                newList.add(1);
                for (int j = 0; j < list.size() - 1; j++) {
                    newList.add(list.get(j) + list.get(j + 1));
                }
                newList.add(1);
                list = newList;
            }
            StringBuilder st = new StringBuilder();
            st.append(" ".repeat(Math.max(0, num - list.size())));
            st.append(list.stream().map(String::valueOf).collect(Collectors.joining(" ")));
            System.out.println(st);
        }
    }

    public static void main(String[] args) {
        PascalTriangle.draw(6);
    }
}
