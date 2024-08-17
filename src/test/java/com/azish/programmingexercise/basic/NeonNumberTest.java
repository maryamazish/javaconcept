package com.azish.programmingexercise.basic;

import com.azish.juni5.ExceptionEnum;
import com.azish.programmingexercise.basic.NeonNumber;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.IOException;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class NeonNumberTest {
    @ParameterizedTest
    @MethodSource("getNumbers")
    void check_success(int number, Boolean expect) {
        assertEquals(expect, NeonNumber.check(number));
    }

    private static Stream<Arguments> getNumbers() {
        return Stream.of(
                Arguments.of(9, true),
                Arguments.of(8, false),
                Arguments.of(11, false)
        );
    }
}
