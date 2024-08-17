package com.azish.java12to14.switchexpression;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class SwitchYieldWorkerTest {
    @ParameterizedTest
    @MethodSource("operateSource")
    void operate_Success(String operation, String input, String expected) {
        String result = SwitchYieldWorker.operate(operation, input);
        assertEquals(expected, result);
    }

    @ParameterizedTest
    @MethodSource("operateSource")
    void operateWithExpression_Success(String operation, String input, String expected) {
        String result = SwitchYieldWorker.operateWithExpression(operation, input);
        assertEquals(expected, result);
    }


    @ParameterizedTest
    @MethodSource("operateSource")
    void operateWithExpressionAndYield_Success(String operation, String input, String expected) {
        String result = SwitchYieldWorker.operateWithExpressionAndYield(operation, input);
        assertEquals(expected, result);
    }

    @Test
    void operate_Failed() {
        assertThrows(IllegalStateException.class,() -> SwitchYieldWorker.operate("trimm", " test"));
    }

    @Test
    void operateWithExpression_Failed() {
        assertThrows(IllegalStateException.class,() -> SwitchYieldWorker.operateWithExpression("trimm", " test"));
    }

    @Test
    void operateWithExpressionAndYield_Failed() {
        assertThrows(IllegalStateException.class,() -> SwitchYieldWorker.operateWithExpressionAndYield("trimm", " test"));
    }

    private static Stream<Arguments> operateSource() {
        return Stream.of(
                Arguments.of("upper", "test", "TEST"),
                Arguments.of("lower", "TesT", "test"),
                Arguments.of("trim", " test  ", "test")
        );
    }

}
