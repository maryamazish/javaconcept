package com.azish.programmingexercise.basic;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertLinesMatch;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ArmstrongNumberTest {
    @Test
    void find_Success(){
        List<Integer> result = ArmstrongNumber.find(100 , 500);
        assertTrue(result.containsAll(List.of(153,370,371,407)));
    }
}
