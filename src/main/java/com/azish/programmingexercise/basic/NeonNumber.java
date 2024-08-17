package com.azish.programmingexercise.basic;

import java.util.ArrayList;
import java.util.List;

public class NeonNumber {
    public static boolean check(int number) {
        int square = number * number;
        Integer sum = 0;
        int remaining;

        while (square > 0) {
            remaining = square % 10;
            sum +=remaining;
            square /= 10;
        }

        return sum.equals(number);
    }

}
