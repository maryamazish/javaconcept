package com.azish.programmingexercise.basic;

import com.azish.programmingexercise.basic.Rectangle;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.rmi.UnexpectedException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class RectangleTest {
    @Test
    void perimeter_Success() throws UnexpectedException {
        int num1 = 5;
        int num2 = 3;
        String userInput = String.format("%s%s%s",
                num1, System.lineSeparator(), num2);
        ByteArrayInputStream bais = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(bais);


        int result = Rectangle.perimeter();

        int expect = 2 * (num1 + num2);

        // checkout output
        assertEquals(expect, result);
    }

    @Test
    void perimeter_Fails() {
        int num1 = 3;
        int num2 = 5;
        String userInput = String.format("%s%s%s",
                num1, System.lineSeparator(), num2);
        ByteArrayInputStream bais = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(bais);

        assertThrows(UnexpectedException.class, Rectangle::perimeter);
    }

}
