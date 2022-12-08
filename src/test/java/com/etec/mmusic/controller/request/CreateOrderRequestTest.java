package com.etec.mmusic.controller.request;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CreateOrderRequestTest {

    @Test
    void getAttendant() {
        CreateOrderRequest createOrderRequest = new CreateOrderRequest();
        createOrderRequest.setAttendant("attendant");
        assertEquals("attendant", createOrderRequest.getAttendant());
    }

    @Test
    void getRequester() {
        CreateOrderRequest createOrderRequest = new CreateOrderRequest();
        createOrderRequest.setRequester("requester");
        assertEquals("requester", createOrderRequest.getRequester());
    }

    @Test
    void getDescription() {
        CreateOrderRequest createOrderRequest = new CreateOrderRequest();
        createOrderRequest.setDescription("description");
        assertEquals("description", createOrderRequest.getDescription());
    }
}