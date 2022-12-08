package com.etec.mmusic.controller.response;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class OrderDetailResponseTest {

    @Test
    void getId() {
        OrderDetailResponse orderDetailResponse = new OrderDetailResponse();
        orderDetailResponse.setId("111");
        assertEquals("111", orderDetailResponse.getId());
    }

    @Test
    void getRequester() {
        OrderDetailResponse orderDetailResponse = new OrderDetailResponse();
        orderDetailResponse.setRequester(
                RequesterResponse.builder()
                        .build()
        );

        assertEquals(RequesterResponse.builder().build(), orderDetailResponse.getRequester());
    }

    @Test
    void getDescription() {
        OrderDetailResponse orderDetailResponse = new OrderDetailResponse();
        orderDetailResponse.setDescription("description");
        assertEquals("description", orderDetailResponse.getDescription());
    }

    @Test
    void getStatus() {
        OrderDetailResponse orderDetailResponse = new OrderDetailResponse();
        orderDetailResponse.setStatus("status");
        assertEquals("status", orderDetailResponse.getStatus());
    }

    @Test
    void testEquals() {
        OrderDetailResponse orderDetailResponse1 = new OrderDetailResponse();
        OrderDetailResponse orderDetailResponse2 = new OrderDetailResponse();

        assertTrue(orderDetailResponse1.equals(orderDetailResponse2) && orderDetailResponse2.equals(orderDetailResponse1));

    }

    @Test
    void canEqual() {
        OrderDetailResponse orderDetailResponse1 = new OrderDetailResponse();
        OrderDetailResponse orderDetailResponse2 = new OrderDetailResponse();

        assertTrue(orderDetailResponse1.canEqual(orderDetailResponse2));

    }

    @Test
    void testHashCode() {
        OrderDetailResponse orderDetailResponse1 = new OrderDetailResponse();
        OrderDetailResponse orderDetailResponse2 = new OrderDetailResponse();

        boolean expected = (orderDetailResponse1.hashCode() == orderDetailResponse2.hashCode());

        assertTrue(expected);
    }

    @Test
    void testToString() {
        OrderDetailResponse orderDetailResponse = new OrderDetailResponse();
        orderDetailResponse.setId("id");
        orderDetailResponse.setDescription("description");
        orderDetailResponse.setStatus("status");
        orderDetailResponse.setRequester(RequesterResponse.builder().build());

        String expected = "OrderDetailResponse(id=id, requester=RequesterResponse(id=null, username=null, status=null), description=description, status=status)";

        assertEquals(expected, orderDetailResponse.toString());
    }

    @Test
    void builder() {
        OrderDetailResponse orderDetailResponse = OrderDetailResponse.builder()
                .id("3242")
                .status("ATTENDANT")
                .description("description")
                .requester(RequesterResponse.builder()
                        .id("id")
                        .username("username")
                        .status("REQUESTER")
                        .build()
                )
                .build();

        RequesterResponse requesterResponseExpected = RequesterResponse.builder()
                .id("id")
                .username("username")
                .status("REQUESTER")
                .build();

        assertEquals("3242", orderDetailResponse.getId());
        assertEquals("ATTENDANT", orderDetailResponse.getStatus());
        assertEquals("description", orderDetailResponse.getDescription());
        assertEquals(requesterResponseExpected, orderDetailResponse.getRequester());
    }

    @Test
    void testOrderDetailResponseBuilderToString() {
        String orderDetailResponseBuilder  = new OrderDetailResponse.OrderDetailResponseBuilder().toString();

        String orderDetailResponseBuilderExpected = new OrderDetailResponse.OrderDetailResponseBuilder().toString();

        assertEquals(orderDetailResponseBuilderExpected, orderDetailResponseBuilder);
    }

    @Test
    void testOrderResponseBuilderHashCode() {
        RequesterResponse requester = new RequesterResponse("id", "username","status");

        OrderDetailResponse.OrderDetailResponseBuilder builder  = new OrderDetailResponse.OrderDetailResponseBuilder();

        boolean requesterExpected =  builder.requester(requester).build().hashCode() ==  builder.requester(requester).build().hashCode();
        boolean idExpected =  builder.id("id").build().hashCode() ==  builder.id("id").build().hashCode();
        boolean statusExpected =  builder.id("status").build().hashCode() ==  builder.id("status").build().hashCode();
        boolean descriptionExpected = builder.description("description").build().hashCode() == builder.description("description").build().hashCode();

        assertTrue(requesterExpected);
        assertTrue(idExpected);
        assertTrue(statusExpected);
        assertTrue(descriptionExpected);
    }

}