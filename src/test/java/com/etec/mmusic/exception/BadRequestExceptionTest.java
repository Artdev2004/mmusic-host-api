package com.etec.mmusic.exception;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BadRequestExceptionTest {

    @Test
    void testBadRequestException() {

        Exception exception = assertThrows(RuntimeException.class, () -> {
            throw new BadRequestException("Bad request");
        });

        String expectedMessage = "Bad request";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));

    }
}