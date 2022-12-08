package com.etec.mmusic.exception;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ResourceNotFoundExceptionTest {
    @Test
    void testResourceNotFoundException() {

        Exception exception = assertThrows(RuntimeException.class, () -> {
            throw new ResourceNotFoundException("Resource not found");
        });

        String expectedMessage = "Resource not found";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));

    }
}