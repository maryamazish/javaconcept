package com.azish.mocking;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mockConstruction;

public class MemberRepositoryFactoryTest {
    @Test
    void create_Success() {

        try (var ignored = mockConstruction(MemberRepository.class)) {
            assertDoesNotThrow(() -> MemberRepositoryFactory.create("localhost" , "3306"));
        }
    }
}
