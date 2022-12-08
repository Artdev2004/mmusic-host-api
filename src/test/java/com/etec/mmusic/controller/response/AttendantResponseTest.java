package com.etec.mmusic.controller.response;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class AttendantResponseTest {

    @Test
    void getId() {
        AttendantResponse attendantResponse = new AttendantResponse();
        attendantResponse.setId("111");
        assertEquals("111", attendantResponse.getId());
    }

    @Test
    void getUsername() {
        AttendantResponse attendantResponse = new AttendantResponse();
        attendantResponse.setUsername("username");
        assertEquals("username", attendantResponse.getUsername());
    }

    @Test
    void getStatus() {
        AttendantResponse attendantResponse = new AttendantResponse();
        attendantResponse.setStatus("ATTENDANT");
        assertEquals("ATTENDANT", attendantResponse.getStatus());
    }

    @Test
    void builder() {
        AttendantResponse attendantResponse = AttendantResponse.builder()
                .id("3242")
                .status("ATTENDANT")
                .username("username").build();
        assertEquals("3242", attendantResponse.getId());
        assertEquals("ATTENDANT", attendantResponse.getStatus());
        assertEquals("username", attendantResponse.getUsername());
    }

    @Test
    void testToString() {
        AttendantResponse attendantResponse = new AttendantResponse();
        attendantResponse.setId("id");
        attendantResponse.setUsername("username");
        attendantResponse.setStatus("status");

        String expected = "AttendantResponse(id=id, username=username, status=status)";

        assertEquals(expected, attendantResponse.toString());
    }

    @Test
    void testEquals() {
        AttendantResponse attendantResponse1 = new AttendantResponse();
        AttendantResponse attendantResponse2 = new AttendantResponse();

        assertTrue(attendantResponse1.equals(attendantResponse2) && attendantResponse2.equals(attendantResponse1));
    }

    @Test
    void canEqual() {
        AttendantResponse attendantResponse1 = new AttendantResponse();
        AttendantResponse attendantResponse2 = new AttendantResponse();

        assertTrue(attendantResponse1.canEqual(attendantResponse2));

    }

    @Test
    void testHashCode() {
        AttendantResponse attendantResponse1 = new AttendantResponse();
        AttendantResponse attendantResponse2 = new AttendantResponse();

        boolean expected = (attendantResponse1.hashCode() == attendantResponse2.hashCode());

        assertTrue(expected);
    }

    @Test
    void testAttendantResponseBuilderToString() {
        String attendantResponseBuilder  = new AttendantResponse.AttendantResponseBuilder().toString();

        String attendantResponseBuilderExpected = new AttendantResponse.AttendantResponseBuilder().toString();

        assertEquals(attendantResponseBuilderExpected, attendantResponseBuilder);
    }

    @Test
    void testAttendantResponseBuilderToEquals() {

        AttendantResponse.AttendantResponseBuilder builder  = new AttendantResponse.AttendantResponseBuilder();

        boolean idExpected =  builder.id("id").build().equals(builder.id("id").build());
        boolean statusExpected =  builder.id("status").build().equals(builder.id("status").build());
        boolean userExpected =  builder.id("description").build().equals(builder.id("description").build());

        assertTrue(idExpected);
        assertTrue(statusExpected);
        assertTrue(userExpected);

    }

    @Test
    void testAttendantResponseBuilderHashCode() {
        AttendantResponse.AttendantResponseBuilder builder  = new AttendantResponse.AttendantResponseBuilder();

        boolean idExpected =  builder.id("id").build().hashCode() ==  builder.id("id").build().hashCode();
        boolean statusExpected =  builder.status("status").build().hashCode() ==  builder.status("status").build().hashCode();
        boolean usernameExpected =  builder.username("username").build().hashCode() ==  builder.username("username").build().hashCode();

        assertTrue(idExpected);
        assertTrue(statusExpected);
        assertTrue(usernameExpected);

    }
}