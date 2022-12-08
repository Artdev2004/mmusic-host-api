package com.etec.mmusic.security.services;

import com.etec.mmusic.controller.response.UserResponse;
import com.etec.mmusic.entity.UserEntity;
import org.junit.jupiter.api.Test;
import org.springframework.security.core.GrantedAuthority;

import java.util.List;
import java.util.Objects;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class UserDetailsImplTest {

    @Test
    void build() {
        UUID uuid = UUID.randomUUID();
        UserEntity userEntity = UserEntity.builder()
                .id(uuid)
                .status("status")
                .build();

        UserDetailsImpl userDetailsImpl = UserDetailsImpl.build(userEntity);

        assertEquals(userEntity.getId(), userDetailsImpl.getId());
    }

    @Test
    void getAuthorities() {
        UUID uuid = UUID.randomUUID();
        UserEntity userEntity = UserEntity.builder()
                .id(uuid)
                .status("status")
                .build();


        UserDetailsImpl userDetailsImpl = UserDetailsImpl.build(userEntity);
        List<GrantedAuthority> authority = (List<GrantedAuthority>) userDetailsImpl.getAuthorities();

        assertEquals("status", authority.get(0).toString());

    }

    @Test
    void getId() {
        UUID uuid = UUID.randomUUID();
        UserEntity userEntity = UserEntity.builder()
                .id(uuid)
                .status("status")
                .build();

        UserDetailsImpl userDetailsImpl = UserDetailsImpl.build(userEntity);

        assertEquals(userEntity.getId(), userDetailsImpl.getId());
    }

    @Test
    void getEmail() {
        UUID uuid = UUID.randomUUID();
        UserEntity userEntity = UserEntity.builder()
                .id(uuid)
                .email("email@gmail.com")
                .status("status")
                .build();

        UserDetailsImpl userDetailsImpl = UserDetailsImpl.build(userEntity);

        assertEquals(userEntity.getEmail(), userDetailsImpl.getEmail());
    }

    @Test
    void getPassword() {
        UUID uuid = UUID.randomUUID();
        UserEntity userEntity = UserEntity.builder()
                .id(uuid)
                .email("email@gmail.com")
                .password("password")
                .status("status")
                .build();

        UserDetailsImpl userDetailsImpl = UserDetailsImpl.build(userEntity);


        assertEquals(userEntity.getPassword(), userDetailsImpl.getPassword());
    }

    @Test
    void getUsername() {
        UUID uuid = UUID.randomUUID();
        UserEntity userEntity = UserEntity.builder()
                .id(uuid)
                .email("email@gmail.com")
                .password("password")
                .username("username")
                .status("status")
                .build();

        UserDetailsImpl userDetailsImpl = UserDetailsImpl.build(userEntity);

        assertEquals(userEntity.getUsername(), userDetailsImpl.getUsername());
    }

    @Test
    void isAccountNonExpired() {
        UUID uuid = UUID.randomUUID();
        UserEntity userEntity = UserEntity.builder()
                .id(uuid)
                .status("status")
                .build();

        UserDetailsImpl userDetailsImpl = UserDetailsImpl.build(userEntity);

        assertTrue(userDetailsImpl.isAccountNonExpired());
    }

    @Test
    void isAccountNonLocked() {
        UUID uuid = UUID.randomUUID();
        UserEntity userEntity = UserEntity.builder()
                .id(uuid)
                .status("status")
                .build();

        UserDetailsImpl userDetailsImpl = UserDetailsImpl.build(userEntity);

        assertTrue(userDetailsImpl.isAccountNonLocked());
    }

    @Test
    void isCredentialsNonExpired() {
        UUID uuid = UUID.randomUUID();
        UserEntity userEntity = UserEntity.builder()
                .id(uuid)
                .status("status")
                .build();

        UserDetailsImpl userDetailsImpl = UserDetailsImpl.build(userEntity);

        assertTrue(userDetailsImpl.isCredentialsNonExpired());
    }

    @Test
    void isEnabled() {

        UUID uuid = UUID.randomUUID();
        UserEntity userEntity = UserEntity.builder()
                .id(uuid)
                .status("status")
                .build();

        UserDetailsImpl userDetailsImpl = UserDetailsImpl.build(userEntity);

        assertTrue(userDetailsImpl.isEnabled());
    }

    @Test
    void testEquals() {

        UUID uuid = UUID.randomUUID();
        UserEntity userEntity = UserEntity.builder()
                .id(uuid)
                .status("status")
                .build();

        UserDetailsImpl userDetailsImpl1 = UserDetailsImpl.build(userEntity);
        UserDetailsImpl userDetailsImpl2 = UserDetailsImpl.build(userEntity);

        UserDetailsImpl userDetailsImpl3 = null;

        assertTrue(userDetailsImpl1.equals(userDetailsImpl2) && userDetailsImpl2.equals(userDetailsImpl1));

        assertFalse(userDetailsImpl1.equals(userDetailsImpl3));

        assertTrue(userDetailsImpl1.equals(userDetailsImpl1));

        assertFalse(userDetailsImpl1.equals(userDetailsImpl2.getClass())) ;

    }
}