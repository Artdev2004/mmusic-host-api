package com.etec.mmusic.exception;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UnauthorizedExceptionTest {


    @Test
    void testUnauthorizedException() {

        Exception exception = assertThrows(RuntimeException.class, () -> {
            throw new UnauthorizedException("Permission Denied");
        });

        String expectedMessage = "Permission Denied";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));

    }

}