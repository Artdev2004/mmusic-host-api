package com.etec.mmusic.controller.request;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CreateUserRequestTest {

    @Test
    void getUsername() {
        CreateUserRequest createUserRequest = new CreateUserRequest();
        createUserRequest.setUsername("username");
        assertEquals("username", createUserRequest.getUsername());
    }

    @Test
    void getEmail() {
        CreateUserRequest createUserRequest = new CreateUserRequest();
        createUserRequest.setEmail("email@gmail.com");
        assertEquals("email@gmail.com", createUserRequest.getEmail());

    }

    @Test
    void getPassword() {
        CreateUserRequest createUserRequest = new CreateUserRequest();
        createUserRequest.setPassword("password");
        assertEquals("password", createUserRequest.getPassword());

    }

    @Test
    void getStatus() {

        CreateUserRequest createUserRequest = new CreateUserRequest();
        createUserRequest.setStatus("ATTENDANT");
        assertEquals("ATTENDANT", createUserRequest.getStatus());

    }
}