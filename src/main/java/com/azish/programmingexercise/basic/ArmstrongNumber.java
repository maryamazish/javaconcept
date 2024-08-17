package com.azish.programmingexercise.basic;

import java.util.ArrayList;
import java.util.List;

public class ArmstrongNumber {

    public static List<Integer> find(int num1, int num2) {

        List<Integer> multiplyDigitsList = new ArrayList<>();
        List<Integer> result = new ArrayList<>();

        int multiply;
        int currentDigit = num1;
        Integer counter = currentDigit;
        int sum = 0;

        while (counter <= num2) {

            //جدا کردن ارقام
            multiplyDigitsList.clear();
            int length = String.valueOf(counter).length();
            while (counter > 0) {
                int x = counter % 10;
                //ضرب هر عدد به تعداد ان بار در خودش
                multiply = 1;
                for (int i = 1; i <= length; i++) {
                    multiply *= x;
                }
                multiplyDigitsList.add(multiply);
                counter /= 10;
            }

            //جمع اعداد ضرب شده
            sum = multiplyDigitsList.stream().reduce(0, Integer::sum);

            if (sum == currentDigit)
                result.add(sum);

            currentDigit++;
            counter = currentDigit;

        }
        return result;

    }

}
