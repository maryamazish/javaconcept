package com.azish.java8to11.optional;

import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

public class OptionalWorkerTest {
    @Test
    void searchOnArray_Success() {
        Integer[] x = {10, 65, 40, 5, 48, 31};
        ;
        assertEquals(40, OptionalWorker.searchOnArray(x, 2));
    }

    @Test
    void test() {
        Optional<Dimension> empty = Optional.empty();
        assertTrue(empty.isEmpty());

        Optional<Dimension> dimensionNull = Optional.ofNullable(OptionalWorker.getDimension(0));
        assertFalse(dimensionNull.isPresent());
        Optional<Dimension> dimension = Optional.ofNullable(OptionalWorker.getDimension(10));
        assertTrue(dimension.isPresent());

        dimension.ifPresent(d -> OptionalWorker.printDimension(d.size()));
        dimension.ifPresentOrElse(d -> OptionalWorker.printDimension(d.size()), () -> {
            throw new RuntimeException("Dimension is null");
        });

        var d = dimension.orElseThrow();
        assertEquals(10, d.size());
        assertThrows(NoSuchElementException.class, () -> dimensionNull.orElseThrow());
        assertThrows(RuntimeException.class, () -> dimensionNull.orElseThrow(() -> new RuntimeException("is null")));

        var d2 = dimensionNull.orElse(new Dimension(20));
        assertNotNull(d2);
        assertEquals(20, d2.size());

        var d3 = dimensionNull.orElseGet(() -> new Dimension(20));
        assertNotNull(d3);
        assertEquals(20, d3.size());

        Optional<Integer> integerOptional = dimension.map(dimension1 -> dimension1.size());
        assertEquals(10, integerOptional.get());

        Optional<Integer> integerOptional2 = integerOptional.filter(number -> number > 10);
        assertFalse(integerOptional2.isPresent());
    }
}
