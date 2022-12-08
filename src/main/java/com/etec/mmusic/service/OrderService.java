package com.etec.mmusic.service;

import com.etec.mmusic.controller.request.CreateOrderRequest;
import com.etec.mmusic.controller.response.AttendantResponse;
import com.etec.mmusic.controller.response.AttendantWithListOrderResponse;
import com.etec.mmusic.controller.response.OrderDetailResponse;
import com.etec.mmusic.controller.response.OrderResponse;
import com.etec.mmusic.entity.OrderEntity;
import com.etec.mmusic.entity.UserEntity;
import com.etec.mmusic.exception.ResourceNotFoundException;
import com.etec.mmusic.repository.OrderRepository;
import com.etec.mmusic.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class OrderService implements IOrderService {

    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<OrderResponse> findAll() {
        List<OrderEntity> orderEntityList = orderRepository.findAll();

        return orderEntityList
                .stream()
                .map(order -> modelMapper.map(order, OrderResponse.class))
                .collect(Collectors.toList());
    }

    @Override
    public OrderResponse findById(String id) {

        OrderEntity orderEntity = orderRepository.findOrderEntityById(UUID.fromString(id));
        if (orderEntity == null) {
            throw new ResourceNotFoundException("Resource not found");
        }

        return modelMapper.map(orderEntity, OrderResponse.class);
    }

    public List<OrderResponse> findByAttendantId(String attendantId) {
        List<OrderEntity> orderEntityList = orderRepository.findByAttendantId(UUID.fromString(attendantId));

        return orderEntityList
                .stream()
                .map(order -> modelMapper.map(order, OrderResponse.class))
                .collect(Collectors.toList());
    }

    public AttendantWithListOrderResponse findByAttendantIdWithOrder(String attendantId) {

        UserEntity attendant = userRepository.findUserEntityById(UUID.fromString(attendantId));
        if(attendant == null) {
            throw new ResourceNotFoundException("Resource not found");
        }
        AttendantResponse attendantResponse = AttendantResponse.builder()
                .id(attendant.getId().toString())
                .username(attendant.getUsername())
                .status(attendant.getStatus())
                .build();

        List<OrderEntity> orderEntityList = orderRepository.findByAttendantId(UUID.fromString(attendantId));
        if(orderEntityList == null) {
            throw new ResourceNotFoundException("Not list of order for be realized");
        }

        List<OrderDetailResponse> listOrderDetails = orderEntityList
                .stream()
                .map(r -> modelMapper.map(r, OrderDetailResponse.class))
                .collect(Collectors.toList());

        return AttendantWithListOrderResponse.builder()
                .attendant(attendantResponse)
                .listOfOrders(listOrderDetails)
                .build();
    }

    @Override
    public void findByOrderIdStatusEqualsUnrealized(String orderId) {
        OrderEntity orderEntity = orderRepository.findByOrderIdStatusEqualsUnrealized(UUID.fromString(orderId));
        if (orderEntity == null) {
            throw new ResourceNotFoundException("Resouce not found for update");
        }
        orderRepository.updateStatusOfOrder(orderEntity.getId());
    }

    public OrderResponse save(CreateOrderRequest createOrderRequest) {

        UserEntity attendant = new UserEntity(UUID.fromString(createOrderRequest.getAttendant()));
        UserEntity requester = new UserEntity(UUID.fromString(createOrderRequest.getRequester()));

        OrderEntity order = OrderEntity.builder()
                .description(createOrderRequest.getDescription())
                .attendant(attendant)
                .requester(requester)
                .timestamp(new Date().toInstant().atZone(ZoneId.of("America/Sao_Paulo")).toLocalDateTime())
                .build();

        OrderEntity orderEntityReturn = orderRepository.save(order);

        return modelMapper.map(orderEntityReturn, OrderResponse.class);

    }
}
