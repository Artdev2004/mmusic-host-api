package com.etec.mmusic.exception;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ForbiddenExceptionTest {

    @Test
    void testForbiddenException() {

        Exception exception = assertThrows(RuntimeException.class, () -> {
            throw new ForbiddenException("Not Authorized");
        });

        String expectedMessage = "Not Authorized";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));

    }
}