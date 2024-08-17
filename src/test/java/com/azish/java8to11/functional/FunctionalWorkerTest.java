package com.azish.java8to11.functional;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class FunctionalWorkerTest {
    @Test
    void test() {
        String password = FunctionalWorker.generateRandomString.get();
        password = FunctionalWorker.complexPassword.apply(password);
        FunctionalWorker.printPassword.accept(password);

        assertTrue(FunctionalWorker.isPasswordComplex.test(password));
    }

    @Test
    void biFunctionTest() {
        assertEquals("num1 + num2 = 501", FunctionalWorker.biFunction.apply(1, 500));
    }

    @Test
    void biPredicateTest() {
        assertTrue(FunctionalWorker.biPredicate.test("hello", "hi"));
    }

    @Test
    void findFirstTest() {
        String password = "one18*";
        List<String> strList = List.of(password, "two14*", "three20*", "four22");

        var findFirst = FunctionalWorker.generateCredentials(strList).findFirst();
        assertEquals(password, findFirst.get().password());

    }

    @Test
    void anyMatchTest() {
        List<String> strList = List.of("one18*", "two14*", "three20*", "four22");

        boolean anyMatch = FunctionalWorker.generateCredentials(strList).anyMatch((s) -> s.password().contains("*"));
        assertTrue(anyMatch);
    }

    @Test
    void findAllTest() {
        String password = "one18*";
        List<String> strList = List.of(password, "two14*", "three20*", "four22");

        boolean anyMatch = FunctionalWorker.generateCredentials(strList).anyMatch((s) -> s.password().contains("*"));
        assertTrue(anyMatch);
    }

}
