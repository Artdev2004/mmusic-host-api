package com.etec.mmusic.entity;

import com.etec.mmusic.controller.response.UserResponse;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class UserEntityTest {

    @Test
    void getId() {
        UUID uuid = UUID.randomUUID();
        UserEntity userEntity = new UserEntity();
        userEntity.setId(uuid);

        assertEquals(uuid, userEntity.getId());

        UserEntity userEntityConstructor = new UserEntity(uuid);

        assertEquals(uuid, userEntityConstructor.getId());

    }

    @Test
    void getUsername() {
        UserEntity userEntity = new UserEntity();
        userEntity.setUsername("username");

        assertEquals("username", userEntity.getUsername());
    }

    @Test
    void getEmail() {
        UserEntity userEntity = new UserEntity();
        userEntity.setEmail("email@gmail.com");

        assertEquals("email@gmail.com", userEntity.getEmail());
    }

    @Test
    void getPassword() {
        UserEntity userEntity = new UserEntity();
        userEntity.setPassword("password");

        assertEquals("password", userEntity.getPassword());
    }

    @Test
    void getStatus() {
        UserEntity userEntity = new UserEntity();
        userEntity.setStatus("status");

        assertEquals("status", userEntity.getStatus());

    }

    @Test
    void getTimestamp() {
        LocalDateTime date = new Date().toInstant().atZone(ZoneId.of("America/Sao_Paulo")).toLocalDateTime();
        UserEntity userEntity = new UserEntity();
        userEntity.setTimestamp(date);

        assertEquals(date, userEntity.getTimestamp());
    }


    @Test
    void builder() {
        UUID uuid = UUID.randomUUID();
        LocalDateTime date = new Date().toInstant().atZone(ZoneId.of("America/Sao_Paulo")).toLocalDateTime();

        UserEntity userEntity = UserEntity.builder()
                .id(uuid)
                .username("username")
                .email("email@gmail.com")
                .password("password")
                .status("status")
                .timestamp(date)
                .build();

        assertEquals(uuid, userEntity.getId());
        assertEquals("username", userEntity.getUsername());
        assertEquals("email@gmail.com", userEntity.getEmail());
        assertEquals("password", userEntity.getPassword());
        assertEquals("status", userEntity.getStatus());
        assertEquals(date, userEntity.getTimestamp());

    }

    @Test
    void testUserEntityBuilderToString() {
        String userEntityBuilder  = new UserEntity.UserEntityBuilder().toString();

        String userEntityBuilderExpected = new UserEntity.UserEntityBuilder().toString();

        assertEquals(userEntityBuilderExpected, userEntityBuilder);
    }
}