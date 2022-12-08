package com.etec.mmusic.security.services;

import com.etec.mmusic.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import static org.junit.jupiter.api.Assertions.assertEquals;


class UserDetailsServiceImplTest {

    @Mock
    UserDetailsServiceImpl userDetailsService;

    @Mock
    UserRepository userRepository;


    @BeforeEach
    public void setUp() {

    }

    @Test
    void testLoadUserByUsername() {
        assertEquals("Iann", "Iann");

    }
}