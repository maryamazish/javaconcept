package com.azish.java8to11.string;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StringJoinTest {
    @Test
    void test(){
        List<String> tokens = List.of("one","two","three");
        String result1 = StringJoin.concatPlus(tokens);
        String result2 = StringJoin.concatJoin(tokens);
        String result3 = StringJoin.concatStringBuilder(tokens);

        assertEquals(result1,result2,result3);
    }
}
