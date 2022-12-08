package com.etec.mmusic.controller.response;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserResponseTest {

    @Test
    void getId() {
        UserResponse userResponse = new UserResponse();
        userResponse.setId("111");
        assertEquals("111", userResponse.getId());
    }

    @Test
    void getUsername() {
        UserResponse userResponse = new UserResponse();
        userResponse.setUsername("username");
        assertEquals("username", userResponse.getUsername());
    }

    @Test
    void getEmail() {
        UserResponse userResponse = new UserResponse();
        userResponse.setEmail("email@gmail.com");
        assertEquals("email@gmail.com", userResponse.getEmail());

    }

    @Test
    void getStatus() {
        UserResponse userResponse = new UserResponse();
        userResponse.setEmail("email@gmail.com");
        assertEquals("email@gmail.com", userResponse.getEmail());

    }

    @Test
    void testEquals() {
        UserResponse userResponse1 = new UserResponse();
        UserResponse userResponse2 = new UserResponse();

        assertTrue(userResponse1.equals(userResponse2) && userResponse2.equals(userResponse1));

    }

    @Test
    void canEqual() {
        UserResponse userResponse1 = new UserResponse();
        UserResponse userResponse2 = new UserResponse();

        assertTrue(userResponse1.canEqual(userResponse2));

    }

    @Test
    void testHashCode() {
        UserResponse userResponse1 = new UserResponse();
        UserResponse userResponse2 = new UserResponse();

        boolean expected = (userResponse2.hashCode() == userResponse1.hashCode());

        assertTrue(expected);
    }

    @Test
    void testToString() {

        UserResponse userResponse = new UserResponse();
        userResponse.setId("id");
        userResponse.setStatus("status");
        userResponse.setEmail("email@gmail.com");
        userResponse.setUsername("username");

        String expected = "UserResponse(id=id, username=username, email=email@gmail.com, status=status)";

        assertEquals(expected, userResponse.toString());
    }

    @Test
    void builder() {
        UserResponse userResponse = UserResponse.builder()
                .id("3242")
                .status("ATTENDANT")
                .email("email@gmail.com")
                .username("username")
                .build();

        assertEquals("3242", userResponse.getId());
        assertEquals("ATTENDANT", userResponse.getStatus());
        assertEquals("email@gmail.com", userResponse.getEmail());
        assertEquals("username", userResponse.getUsername());
    }

    @Test
    void testUserResponseBuilderToString() {
        String userResponseBuilder  = new UserResponse.UserResponseBuilder().toString();

        String userResponseBuilderExpected = new UserResponse.UserResponseBuilder().toString();

        assertEquals(userResponseBuilderExpected, userResponseBuilder);
    }

    @Test
    void testUserResponseBuilderHashCode() {
        UserResponse.UserResponseBuilder builder  = new UserResponse.UserResponseBuilder();

        boolean idExpected =  builder.id("id").build().hashCode() ==  builder.id("id").build().hashCode();
        boolean usernameExpected =  builder.username("username").build().hashCode() ==  builder.username("username").build().hashCode();
        boolean statusExpected =  builder.status("status").build().hashCode() ==  builder.status("status").build().hashCode();
        boolean emailExpected =  builder.email("email@gmail.com").build().hashCode() ==  builder.email("email@gmail.com").build().hashCode();

        assertTrue(idExpected);
        assertTrue(usernameExpected);
        assertTrue(statusExpected);
        assertTrue(emailExpected);

    }
}