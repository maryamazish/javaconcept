package com.azish.java15to17.sealedclass;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HumanTest {
    @ParameterizedTest
    @MethodSource("makeHuman")
    void printName_Success(Human human, String expected) {
        String result = human.printName();
        assertEquals(expected, result);
    }

    private static Stream<Arguments> makeHuman() {
        return Stream.of(
                Arguments.of(new Employee(), "Employee name"),
                Arguments.of(new Manager(), "Manager Name"),
                Arguments.of(new Student(), "Student name")
        );
    }
}
