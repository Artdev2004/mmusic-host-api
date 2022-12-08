package com.etec.mmusic.controller.response;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class AttendantWithListOrderResponseTest {

    @Test
    void getAttendant() {
        AttendantWithListOrderResponse attendantWithListOrderResponse = new AttendantWithListOrderResponse();
        attendantWithListOrderResponse.setAttendant(AttendantResponse.builder()
                .id("id")
                .status("status")
                .username("username")
                .build()
        );

        AttendantResponse expected = AttendantResponse.builder()
                .id("id")
                .status("status")
                .username("username")
                .build();

        assertEquals(expected, attendantWithListOrderResponse.getAttendant());
    }

    @Test
    void getListOfOrders() {
        AttendantWithListOrderResponse attendantWithListOrderResponse = new AttendantWithListOrderResponse();
        attendantWithListOrderResponse.setListOfOrders(
                List.of(OrderDetailResponse.builder()
                                .id("id")
                                .description("description")
                                .status("status")
                                .requester(
                                        RequesterResponse.builder()
                                                .id("id")
                                                .username("username")
                                                .status("status")
                                                .build()
                                )
                        .build())
        );

        List<OrderDetailResponse> expected = List.of(OrderDetailResponse.builder()
                .id("id")
                .description("description")
                .status("status")
                .requester(
                        RequesterResponse.builder()
                                .id("id")
                                .username("username")
                                .status("status")
                                .build()
                )
                .build()
        );

        assertEquals(expected, attendantWithListOrderResponse.getListOfOrders());

    }

    @Test
    void testEquals() {
        AttendantWithListOrderResponse attendantWithListOrderResponse1 = new AttendantWithListOrderResponse();
        AttendantWithListOrderResponse attendantWithListOrderResponse2 = new AttendantWithListOrderResponse();

        assertTrue(attendantWithListOrderResponse1.equals(attendantWithListOrderResponse2) && attendantWithListOrderResponse2.equals(attendantWithListOrderResponse1));

    }

    @Test
    void canEqual() {
        AttendantWithListOrderResponse attendantWithListOrderResponse1 = new AttendantWithListOrderResponse();
        AttendantWithListOrderResponse attendantWithListOrderResponse2 = new AttendantWithListOrderResponse();

        assertTrue(attendantWithListOrderResponse1.canEqual(attendantWithListOrderResponse2));

    }

    @Test
    void testHashCode() {
        AttendantWithListOrderResponse attendantWithListOrderResponse1 = new AttendantWithListOrderResponse();
        AttendantWithListOrderResponse attendantWithListOrderResponse2 = new AttendantWithListOrderResponse();

        boolean expected = (attendantWithListOrderResponse1.hashCode() == attendantWithListOrderResponse2.hashCode());

        assertTrue(expected);

    }

    @Test
    void testToString() {

        AttendantWithListOrderResponse attendantWithListOrderResponse = new AttendantWithListOrderResponse();
        attendantWithListOrderResponse.setAttendant(AttendantResponse.builder()
                        .id("id")
                        .username("username")
                        .status("status")
                        .build());

        attendantWithListOrderResponse.setListOfOrders(List.of(OrderDetailResponse.builder()
                .id("id")
                .description("description")
                .status("status")
                .requester(
                        RequesterResponse.builder()
                                .id("id")
                                .username("username")
                                .status("status")
                                .build()
                )
                .build()
        ));

        String expected = "AttendantWithListOrderResponse(attendant=AttendantResponse(id=id, username=username, " +
                "status=status), listOfOrders=[OrderDetailResponse(id=id, requester=RequesterResponse(id=id, " +
                "username=username, status=status), description=description, status=status)])";

        assertEquals(expected, attendantWithListOrderResponse.toString());
    }

    @Test
    void builder() {

        AttendantWithListOrderResponse attendantWithListOrderResponse = AttendantWithListOrderResponse.builder()
                .attendant(
                        AttendantResponse.builder()
                        .id("id")
                        .username("username")
                        .status("status")
                        .build())
                .listOfOrders(List.of(
                        OrderDetailResponse.builder()
                        .id("id")
                        .description("description")
                        .status("status")
                        .requester(
                                RequesterResponse.builder()
                                        .id("id")
                                        .username("username")
                                        .status("status")
                                        .build()
                        )
                        .build()
                ))
                .build();

        AttendantResponse attendantResponseExpected = AttendantResponse.builder()
                .id("id")
                .username("username")
                .status("status")
                .build();

        List<OrderDetailResponse> orderDetailResponsesExpected = List.of(OrderDetailResponse.builder()
                .id("id")
                .description("description")
                .status("status")
                .requester(
                        RequesterResponse.builder()
                                .id("id")
                                .username("username")
                                .status("status")
                                .build()
                )
                .build()
        );

        assertEquals(attendantResponseExpected, attendantWithListOrderResponse.getAttendant());
        assertEquals(orderDetailResponsesExpected, attendantWithListOrderResponse.getListOfOrders());
    }

    @Test
    void testAttendantWithListOrderResponseBuilderToString() {
        String attendantWithListOrderResponseBuilder  = new AttendantWithListOrderResponse.AttendantWithListOrderResponseBuilder().toString();

        String attendantWithListOrderResponseBuilderExpected = new AttendantWithListOrderResponse.AttendantWithListOrderResponseBuilder().toString();

        assertEquals(attendantWithListOrderResponseBuilderExpected, attendantWithListOrderResponseBuilder);
    }

    @Test
    void testOrderResponseBuilderHashCode() {
        AttendantResponse attendant = new AttendantResponse("id", "username","status");
        RequesterResponse requester = new RequesterResponse("id", "username","status");

        OrderDetailResponse orderDetailResponse = new OrderDetailResponse();
        orderDetailResponse.setId("id");
        orderDetailResponse.setDescription("description");
        orderDetailResponse.setStatus("status");
        orderDetailResponse.setRequester(requester);

        AttendantWithListOrderResponse.AttendantWithListOrderResponseBuilder builder  = new AttendantWithListOrderResponse.AttendantWithListOrderResponseBuilder();

        boolean attendantExpected =  builder.attendant(attendant).build().hashCode() ==  builder.attendant(attendant).build().hashCode();
        boolean listOfOrdersExpected =  builder.listOfOrders(List.of(orderDetailResponse)).build().hashCode() ==  builder.listOfOrders(List.of(orderDetailResponse)).build().hashCode();

        assertTrue(attendantExpected);
        assertTrue(listOfOrdersExpected);
    }
}