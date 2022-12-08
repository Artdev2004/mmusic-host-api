package com.etec.mmusic.controller.response;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserTokenResponseTest {

    @Test
    void getAccessToken() {
        UserTokenResponse userTokenResponse = new UserTokenResponse();
        userTokenResponse.setAccessToken("accessToken");

        assertEquals("accessToken", userTokenResponse.getAccessToken());
    }


    @Test
    void testEquals() {
        UserTokenResponse userTokenResponse1 = new UserTokenResponse();
        UserTokenResponse userTokenResponse2 = new UserTokenResponse();

        assertTrue(userTokenResponse1.equals(userTokenResponse2) && userTokenResponse2.equals(userTokenResponse1));
    }

    @Test
    void canEqual() {
        UserTokenResponse userTokenResponse1 = new UserTokenResponse();
        UserTokenResponse userTokenResponse2 = new UserTokenResponse();

        assertTrue(userTokenResponse1.canEqual(userTokenResponse2));
    }

    @Test
    void testHashCode() {
        UserTokenResponse userTokenResponse1 = new UserTokenResponse();
        UserTokenResponse userTokenResponse2 = new UserTokenResponse();

        boolean expected = (userTokenResponse1.hashCode() == userTokenResponse2.hashCode());

        assertTrue(expected);
    }

    @Test
    void testToString() {
        UserTokenResponse userTokenResponse = new UserTokenResponse();
        userTokenResponse.setAccessToken("accessToken");
        userTokenResponse.setId("id");
        userTokenResponse.setUsername("username");
        userTokenResponse.setStatus("status");


        String expected = "UserTokenResponse(accessToken=accessToken, id=id, username=username, status=status)";

        assertEquals(expected, userTokenResponse.toString());
    }

    @Test
    void builder() {

        UserTokenResponse userTokenResponse = UserTokenResponse.builder()
                .accessToken("accessToken")
                .id("id")
                .username("username")
                .status("status")
                .build();

        assertEquals("accessToken", userTokenResponse.getAccessToken());
        assertEquals("id", userTokenResponse.getId());
        assertEquals("username",  userTokenResponse.getUsername());
        assertEquals("status", userTokenResponse.getStatus());

    }

    @Test
    void testUserTokenResponseBuilderToString() {
        String userTokenResponseBuilder  = new UserTokenResponse.UserTokenResponseBuilder().toString();

        String userTokenResponseBuilderExpected = new UserTokenResponse.UserTokenResponseBuilder().toString();

        assertEquals(userTokenResponseBuilderExpected, userTokenResponseBuilder);
    }

    @Test
    void testUserTokenResponseBuilderHashCode() {
        UserTokenResponse.UserTokenResponseBuilder builder1  = new UserTokenResponse.UserTokenResponseBuilder();
        builder1.accessToken("accessToken");

        UserTokenResponse.UserTokenResponseBuilder builder2  = new UserTokenResponse.UserTokenResponseBuilder();
        builder2.id("id");

        UserTokenResponse.UserTokenResponseBuilder builder3  = new UserTokenResponse.UserTokenResponseBuilder();
        builder3.username("username");

        UserTokenResponse.UserTokenResponseBuilder builder4  = new UserTokenResponse.UserTokenResponseBuilder();
        builder4.status("status");

        boolean accessTokenExpected =  builder1.accessToken("accessToken").build().hashCode() ==  builder1.accessToken("accessToken").build().hashCode();
        boolean idExpected =  builder2.id("id").build().hashCode() ==  builder2.id("id").build().hashCode();
        boolean usernameExpected =  builder3.username("username").build().hashCode() ==  builder3.username("username").build().hashCode();
        boolean statusExpected =  builder4.status("status").build().hashCode() ==  builder4.status("status").build().hashCode();


        assertTrue(accessTokenExpected);
        assertTrue(idExpected);
        assertTrue(usernameExpected);
        assertTrue(statusExpected);

    }

    @Test
    void testUserTokenResponseBuilderEquals() {

        UserTokenResponse.UserTokenResponseBuilder builder1  = new UserTokenResponse.UserTokenResponseBuilder();
        builder1.accessToken("accessToken");

        UserTokenResponse.UserTokenResponseBuilder builder2  = new UserTokenResponse.UserTokenResponseBuilder();
        builder2.id("id");

        UserTokenResponse.UserTokenResponseBuilder builder3  = new UserTokenResponse.UserTokenResponseBuilder();
        builder3.username("username");

        UserTokenResponse.UserTokenResponseBuilder builder4  = new UserTokenResponse.UserTokenResponseBuilder();
        builder4.status("status");

        boolean accessTokenExpected = builder1.accessToken("accessToken").build().equals(builder1.accessToken("accessToken").build());
        boolean idExpected =  builder2.id("id").build().equals(builder2.id("id").build());
        boolean usernameExpected =  builder3.username("username").build().equals(builder3.username("username").build());
        boolean statusExpected =  builder4.status("status").build().equals(builder4.status("status").build());

        assertTrue(accessTokenExpected);
        assertTrue(idExpected);
        assertTrue(usernameExpected);
        assertTrue(statusExpected);

    }

    @Test
    void getId() {
        UserTokenResponse userTokenResponse = new UserTokenResponse();
        userTokenResponse.setId("id");

        assertEquals("id", userTokenResponse.getId());
    }

    @Test
    void getUsername() {
        UserTokenResponse userTokenResponse = new UserTokenResponse();
        userTokenResponse.setUsername("username");

        assertEquals("username", userTokenResponse.getUsername());
    }

    @Test
    void getStatus() {
        UserTokenResponse userTokenResponse = new UserTokenResponse();
        userTokenResponse.setStatus("username");

        assertEquals("username", userTokenResponse.getStatus());
    }
}