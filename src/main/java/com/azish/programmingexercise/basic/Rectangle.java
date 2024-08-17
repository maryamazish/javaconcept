package com.azish.programmingexercise.basic;

import java.io.ByteArrayInputStream;
import java.rmi.UnexpectedException;
import java.util.Scanner;

public class Rectangle {
    public static int perimeter() throws UnexpectedException {
        Scanner input = new Scanner(System.in);

        System.out.println("Enter length : ");
        int length = input.nextInt();
        System.out.println("length is : " + length);

        System.out.println("Enter width : ");
        int width = input.nextInt();
        System.out.println("width is : " + width);

        if(length<=width)
            throw new UnexpectedException("length must not be smaller than width");

        int result = 2 * (length +  width);
        System.out.println("result is " + result);


        return result;
    }

}
