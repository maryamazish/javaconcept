package com.azish.junit5;

import com.azish.juni5.ExceptionUtility;
import com.azish.juni5.ExceptionEnum;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.IOException;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ExceptionUtilityTest {

    @ParameterizedTest
    @MethodSource("generateSource1")
    void generateTest(ExceptionEnum exceptionEnum, Exception exception, Integer expected) {
        Integer result = ExceptionUtility.generate(exceptionEnum, exception);
        assertEquals(expected, result);
    }

    private static Stream<Arguments> generateSource1() {
        return Stream.of(
                Arguments.of(ExceptionEnum.RUNTIME,new RuntimeException("test0"),0),
                Arguments.of(ExceptionEnum.IO,new IOException("test1"),1),
                Arguments.of(ExceptionEnum.NULL_POINTER,new NullPointerException("test2"),2),
                Arguments.of(ExceptionEnum.NULL_POINTER,new NullPointerException(""),-1)
        );
    }
}
