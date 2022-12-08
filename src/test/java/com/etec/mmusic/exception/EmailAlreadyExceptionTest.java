package com.etec.mmusic.exception;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EmailAlreadyExceptionTest {


    @Test
    void testEmailAlreadyException() {

        Exception exception = assertThrows(RuntimeException.class, () -> {
            throw new EmailAlreadyException("Email already");
        });

        String expectedMessage = "Email already";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));

    }

}