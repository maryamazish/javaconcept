package com.azish.junit5.phone;

import com.azish.juni5.phone.PhoneValidationServiceImpl;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PhoneValidationServiceImplTest {
    private final PhoneValidationServiceImpl phoneValidationService = new PhoneValidationServiceImpl();

    @ParameterizedTest
    @ValueSource(strings = {"09127771396", "09124376251", "09537897"})
    void validatePhone_Success(String phoneNo) {
        assertTrue(phoneValidationService.validatePhone(phoneNo));
    }

    @ParameterizedTest
    @ValueSource(strings = {"@154", "test", "7897"})
    @NullSource
    void validatePhone_Failed(String phoneNo) {
        assertFalse(phoneValidationService.validatePhone(phoneNo));
    }
}
