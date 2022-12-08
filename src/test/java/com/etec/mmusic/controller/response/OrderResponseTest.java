package com.etec.mmusic.controller.response;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OrderResponseTest {

    @Test
    void getId() {
        OrderResponse orderResponse = new OrderResponse();
        orderResponse.setId("111");
        assertEquals("111", orderResponse.getId());
    }

    @Test
    void getAttendant() {
        OrderResponse orderResponse = new OrderResponse();
        orderResponse.setAttendant(
                AttendantResponse.builder()
                        .build()
        );

        assertEquals(AttendantResponse.builder().build(), orderResponse.getAttendant());
    }

    @Test
    void getRequester() {
        OrderResponse orderResponse = new OrderResponse();
        orderResponse.setRequester(
                RequesterResponse.builder()
                        .build()
        );

        assertEquals(RequesterResponse.builder().build(), orderResponse.getRequester());
    }

    @Test
    void getDescription() {
        OrderResponse orderResponse = new OrderResponse();
        orderResponse.setDescription("description");

        assertEquals("description", orderResponse.getDescription());

    }

    @Test
    void getStatus() {
        OrderResponse orderResponse = new OrderResponse();
        orderResponse.setStatus("UNREALIZED");

        assertEquals("UNREALIZED", orderResponse.getStatus());
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
        OrderResponse orderResponse = new OrderResponse();
        orderResponse.setId("id");
        orderResponse.setDescription("description");
        orderResponse.setStatus("status");
        orderResponse.setAttendant(AttendantResponse.builder().build());
        orderResponse.setRequester(RequesterResponse.builder().build());

        String expected = "OrderResponse(id=id, attendant=AttendantResponse(id=null, username=null, status=null), requester=RequesterResponse(id=null, username=null, status=null), description=description, status=status)";

        assertEquals(expected, orderResponse.toString());
    }

    @Test
    void builder() {
        OrderResponse orderResponse = OrderResponse.builder()
                .id("3242")
                .status("ATTENDANT")
                .description("description")
                .attendant(AttendantResponse.builder()
                        .id("id")
                        .username("username")
                        .status("ATTENDANT")
                        .build()
                )
                .requester(RequesterResponse.builder()
                        .id("id")
                        .username("username")
                        .status("REQUESTER")
                        .build()
                )
                .build();

        AttendantResponse attendantResponseExpected = AttendantResponse.builder()
                .id("id")
                .username("username")
                .status("ATTENDANT")
                .build();

        RequesterResponse requesterResponseExpected = RequesterResponse.builder()
                .id("id")
                .username("username")
                .status("REQUESTER")
                .build();

        assertEquals("3242", orderResponse.getId());
        assertEquals("ATTENDANT", orderResponse.getStatus());
        assertEquals("description", orderResponse.getDescription());
        assertEquals(attendantResponseExpected, orderResponse.getAttendant());
        assertEquals(requesterResponseExpected, orderResponse.getRequester());

    }

    @Test
    void testOrderResponseBuilderToString() {
        String orderResponseBuilder  = new OrderResponse.OrderResponseBuilder().toString();

        String orderResponseBuilderExpected = new OrderResponse.OrderResponseBuilder().toString();

        assertEquals(orderResponseBuilderExpected, orderResponseBuilder);
    }

    @Test
    void testOrderResponseBuilderCanEqual() {
        RequesterResponse requester = new RequesterResponse("id", "username","status");
        OrderResponse.OrderResponseBuilder orderResponseBuilder1  = new OrderResponse.OrderResponseBuilder();
        boolean expected =  orderResponseBuilder1.requester(requester).build().canEqual(orderResponseBuilder1.requester(requester).build());

        assertTrue(expected);
    }

    @Test
    void testOrderResponseBuilderHashCode() {
        AttendantResponse attendant = new AttendantResponse("id", "username","status");
        RequesterResponse requester = new RequesterResponse("id", "username","status");

        OrderResponse.OrderResponseBuilder builder1 = new OrderResponse.OrderResponseBuilder();
        builder1.id("id");

        OrderResponse.OrderResponseBuilder builder2 = new OrderResponse.OrderResponseBuilder();
        builder2.status("status");

        OrderResponse.OrderResponseBuilder builder3  = new OrderResponse.OrderResponseBuilder();
        builder3.description("description");

        OrderResponse.OrderResponseBuilder builder4  = new OrderResponse.OrderResponseBuilder();
        builder4.attendant(attendant);

        OrderResponse.OrderResponseBuilder builder5  = new OrderResponse.OrderResponseBuilder();
        builder5.requester(requester);

        boolean idExpected =  builder1.id("id").build().hashCode() ==  builder1.id("id").build().hashCode();
        boolean statusExpected =  builder2.id("status").build().hashCode() ==  builder2.id("status").build().hashCode();
        boolean descriptionExpected = builder3.description("description").build().hashCode() == builder3.description("description").build().hashCode();
        boolean attendantExpected =  builder4.attendant(attendant).build().hashCode() ==  builder4.attendant(attendant).build().hashCode();
        boolean requesterExpected =  builder5.requester(requester).build().hashCode() ==  builder5.requester(requester).build().hashCode();

        assertTrue(requesterExpected);
        assertTrue(attendantExpected);
        assertTrue(idExpected);
        assertTrue(statusExpected);
        assertTrue(descriptionExpected);
    }

    @Test
    void testOrderResponseBuilderEquals() {
        AttendantResponse attendant = new AttendantResponse("id", "username","status");
        RequesterResponse requester = new RequesterResponse("id", "username","status");

        OrderResponse.OrderResponseBuilder builder1 = new OrderResponse.OrderResponseBuilder();
        builder1.id("id");

        OrderResponse.OrderResponseBuilder builder2 = new OrderResponse.OrderResponseBuilder();
        builder2.status("status");

        OrderResponse.OrderResponseBuilder builder3  = new OrderResponse.OrderResponseBuilder();
        builder3.description("description");

        OrderResponse.OrderResponseBuilder builder4  = new OrderResponse.OrderResponseBuilder();
        builder4.attendant(attendant);

        OrderResponse.OrderResponseBuilder builder5  = new OrderResponse.OrderResponseBuilder();
        builder5.requester(requester);

        boolean idExpected =  builder1.id("id").build().equals(builder1.id("id").build());
        boolean statusExpected =  builder2.id("status").build().equals(builder2.id("status").build());
        boolean descriptionExpected = builder3.description("description").build().equals(builder3.description("description").build());
        boolean attendantExpected =  builder4.attendant(attendant).build().equals(builder4.attendant(attendant).build());
        boolean requesterExpected =  builder5.requester(requester).build().equals(builder5.requester(requester).build());

        assertTrue(requesterExpected);
        assertTrue(attendantExpected);
        assertTrue(idExpected);
        assertTrue(statusExpected);
        assertTrue(descriptionExpected);

    }
}