package com.azish.programmingexercise.basic;

public class BinarySearch {
    public static int search(int[] myArray, Integer target) {

        int from = 0;
        int to = myArray.length - 1;
        int mid = -1;

        while (from < to) {
            mid = (from + to) / 2;
            if (myArray[mid] == target)
                return mid;

            else if (myArray[mid] > target)
                to = mid - 1;

            else //(myArray[mid] < target)
                from = mid + 1;
        }
        return mid;
    }
}
