package com.etec.mmusic.controller.request;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LoginRequestTest {

    @Test
    void getUsername() {
        LoginRequest loginRequest = new LoginRequest();
        loginRequest.setUsername("username");
        assertEquals("username", loginRequest.getUsername());
    }

    @Test
    void getPassword() {
        LoginRequest loginRequest = new LoginRequest();
        loginRequest.setPassword("password");
        assertEquals("password", loginRequest.getPassword());
    }

}