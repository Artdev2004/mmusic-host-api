package com.etec.mmusic.entity;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class OrderEntityTest {

    @Test
    void getId() {
        UUID uuid = UUID.randomUUID();
        OrderEntity userEntity = new OrderEntity();
        userEntity.setId(uuid);

        assertEquals(uuid, userEntity.getId());
    }

    @Test
    void getAttendant() {
        UserEntity attendant = new UserEntity();
        OrderEntity orderEntity = new OrderEntity();
        orderEntity.setAttendant(attendant);

        assertEquals(attendant, orderEntity.getAttendant());
    }

    @Test
    void getRequester() {
        UserEntity requester = new UserEntity();
        OrderEntity orderEntity = new OrderEntity();
        orderEntity.setRequester(requester);

        assertEquals(requester, orderEntity.getRequester());
    }

    @Test
    void getDescription() {
        OrderEntity orderEntity = new OrderEntity();
        orderEntity.setDescription("description");

        assertEquals("description", orderEntity.getDescription());

    }

    @Test
    void getStatus() {
        OrderEntity orderEntity = new OrderEntity();
        orderEntity.setStatus("status");

        assertEquals("status", orderEntity.getStatus());
    }

    @Test
    void getTimestamp() {
        LocalDateTime date = new Date().toInstant().atZone(ZoneId.of("America/Sao_Paulo")).toLocalDateTime();
        OrderEntity orderEntity = new OrderEntity();
        orderEntity.setTimestamp(date);

        assertEquals(date, orderEntity.getTimestamp());
    }

    @Test
    void builder() {
        UUID uuid = UUID.randomUUID();
        LocalDateTime date = new Date().toInstant().atZone(ZoneId.of("America/Sao_Paulo")).toLocalDateTime();

        UserEntity attendant = UserEntity.builder().build();
        UserEntity requester = UserEntity.builder().build();

        OrderEntity orderEntity = OrderEntity.builder()
                .id(uuid)
                .attendant(attendant)
                .requester(requester)
                .description("description")
                .status("status")
                .timestamp(date)
                .build();

        assertEquals(uuid, orderEntity.getId());
        assertEquals(attendant, orderEntity.getAttendant());
        assertEquals(requester, orderEntity.getRequester());
        assertEquals("description", orderEntity.getDescription());
        assertEquals("status", orderEntity.getStatus());
        assertEquals(date, orderEntity.getTimestamp());
    }

    @Test
    void testOrderEntityBuilderToString() {
        String orderEntityBuilder  = new OrderEntity.OrderEntityBuilder().toString();

        String orderEntityBuilderExpected = new OrderEntity.OrderEntityBuilder().toString();

        assertEquals(orderEntityBuilderExpected, orderEntityBuilder);
    }
}