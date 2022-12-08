package com.etec.mmusic.service;

import com.etec.mmusic.controller.request.CreateOrderRequest;
import com.etec.mmusic.controller.response.AttendantWithListOrderResponse;
import com.etec.mmusic.controller.response.OrderResponse;

import java.util.List;

public interface IOrderService {

    public List<OrderResponse> findAll();
    public OrderResponse findById(String id);
    public List<OrderResponse> findByAttendantId(String attendantId);
    public OrderResponse save(CreateOrderRequest request);

    AttendantWithListOrderResponse findByAttendantIdWithOrder(String id);

    void findByOrderIdStatusEqualsUnrealized(String orderId);
}
