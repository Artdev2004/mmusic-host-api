package com.etec.mmusic.exception;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class InternalServerErrorExceptionTest {
    @Test
    void testInternalServerErrorException() {

        Exception exception = assertThrows(Exception.class, () -> {
            throw new InternalServerErrorException("Internal server error");
        });

        String expectedMessage = "Internal server error";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));

    }
}