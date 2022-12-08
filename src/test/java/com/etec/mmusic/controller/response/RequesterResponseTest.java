package com.etec.mmusic.controller.response;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class RequesterResponseTest {

    @Test
    void getId() {
        RequesterResponse requesterResponse = new RequesterResponse();
        requesterResponse.setId("111");

        assertEquals("111", requesterResponse.getId());

    }

    @Test
    void getUsername() {
        RequesterResponse requesterResponse = new RequesterResponse();
        requesterResponse.setUsername("username");

        assertEquals("username", requesterResponse.getUsername());

    }

    @Test
    void getStatus() {
        RequesterResponse requesterResponse = new RequesterResponse();
        requesterResponse.setStatus("status");

        assertEquals("status", requesterResponse.getStatus());

    }

    @Test
    void testEquals() {
        RequesterResponse requesterResponse1 = new RequesterResponse();
        RequesterResponse requesterResponse2 = new RequesterResponse();

        assertTrue(requesterResponse1.equals(requesterResponse2) && requesterResponse2.equals(requesterResponse1));

    }

    @Test
    void canEqual() {
        RequesterResponse requesterResponse1 = new RequesterResponse();
        RequesterResponse requesterResponse2 = new RequesterResponse();

        assertTrue(requesterResponse1.canEqual(requesterResponse2));
    }

    @Test
    void testHashCode() {
        RequesterResponse requesterResponse1 = new RequesterResponse();
        RequesterResponse requesterResponse2 = new RequesterResponse();

        boolean expected = (requesterResponse1.hashCode() == requesterResponse2.hashCode());

        assertTrue(expected);
    }

    @Test
    void testToString() {
        RequesterResponse requesterResponse = new RequesterResponse();
        requesterResponse.setId("id");
        requesterResponse.setUsername("username");
        requesterResponse.setStatus("status");

        String expected = "RequesterResponse(id=id, username=username, status=status)";

        assertEquals(expected, requesterResponse.toString());
    }

    @Test
    void builder() {
        RequesterResponse requesterResponse = RequesterResponse.builder()
                .id("3242")
                .status("REQUESTER")
                .username("username")
                .build();

        assertEquals("3242", requesterResponse.getId());
        assertEquals("REQUESTER", requesterResponse.getStatus());
        assertEquals("username", requesterResponse.getUsername());
    }

    @Test
    void testRequesterResponseBuilderToString() {
        String requesterResponseBuilder  = new RequesterResponse.RequesterResponseBuilder().toString();

        String requesterResponseBuilderExpected = new RequesterResponse.RequesterResponseBuilder().toString();;

        assertEquals(requesterResponseBuilderExpected, requesterResponseBuilder);
    }

    @Test
    void testRequesterResponseBuilderHashCode() {
        RequesterResponse.RequesterResponseBuilder builder  = new RequesterResponse.RequesterResponseBuilder();

        boolean idExpected =  builder.id("id").build().hashCode() ==  builder.id("id").build().hashCode();
        boolean usernameExpected =  builder.username("username").build().hashCode() ==  builder.username("username").build().hashCode();
        boolean statusExpected =  builder.status("status").build().hashCode() ==  builder.status("status").build().hashCode();

        assertTrue(idExpected);
        assertTrue(usernameExpected);
        assertTrue(statusExpected);

    }

}