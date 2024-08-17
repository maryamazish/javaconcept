package com.azish.programmingexercise.basic;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BinarySearchTest {
    @Test
    void search_Success() {
        int result = BinarySearch.search(new int[]{1, 2, 8, 50, 100}, 50);
        assertEquals(3, result);
    }
}
