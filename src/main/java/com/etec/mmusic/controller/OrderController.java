package com.etec.mmusic.controller;

import com.etec.mmusic.controller.request.CreateOrderRequest;
import com.etec.mmusic.controller.response.AttendantWithListOrderResponse;
import com.etec.mmusic.controller.response.OrderResponse;
import com.etec.mmusic.service.IOrderService;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/orders")
@Tag(name = "API REST of orders musics")
public class OrderController {

    @Autowired
    private IOrderService orderService;

    @GetMapping
    @Operation(summary = "Return an list of orders")
    @ApiResponses(value = {@ApiResponse(code =   500, message = "Internal server error"),
            @ApiResponse(code =   200, message = "Ok", response = OrderResponse.class)})
    public ResponseEntity<List<OrderResponse>> findAll() {
        return ResponseEntity.ok(orderService.findAll());
    }

    @GetMapping(path = {"/{id}"})
    @Operation(summary = "Return an order")
    @ApiResponses(value = {@ApiResponse(code =   500, message = "Internal server error"),
            @ApiResponse(code =   404, message = "Resource not found"),
            @ApiResponse(code =   200, message = "Ok", response = OrderResponse.class)})
    public ResponseEntity<OrderResponse> findById(@PathVariable String id) {
        return ResponseEntity.ok(orderService.findById(id));
    }

    @GetMapping(path = {"/user/{attendantId}"})
    @Operation(summary = "Return an list of orders")
    @ApiResponses(value = {@ApiResponse(code =   500, message = "Internal server error"),
            @ApiResponse(code =   404, message = "Resource not found"),
            @ApiResponse(code =   200, message = "Ok", response = OrderResponse.class)})
    public ResponseEntity<List<OrderResponse>> findByAttendantId(@PathVariable String attendantId) {
        return ResponseEntity.ok(orderService.findByAttendantId(attendantId));
    }

    @GetMapping(path = {"/user/{attendantId}/list"})
    @Operation(summary = "Return an list of orders")
    @ApiResponses(value = {@ApiResponse(code =   500, message = "Internal server error"),
            @ApiResponse(code =   404, message = "Resource not found"),
            @ApiResponse(code =   200, message = "Ok", response = OrderResponse.class)})
    public ResponseEntity<AttendantWithListOrderResponse> findByAttendantIdListOrder(@PathVariable String attendantId) {
        return ResponseEntity.ok(orderService.findByAttendantIdWithOrder(attendantId));
    }


    @PostMapping
    @Operation(summary = "Return an list of orders")
    @ApiResponses(value = {@ApiResponse(code =   500, message = "Internal server error"),
            @ApiResponse(code =   400, message = "Bad request"),
            @ApiResponse(code =   404, message = "Resource not found"),
            @ApiResponse(code =   201, message = "Created", response = OrderResponse.class)})
    public ResponseEntity<OrderResponse> save(@RequestBody @Valid CreateOrderRequest createOrderRequest){
        return new ResponseEntity<>(orderService.save(createOrderRequest), HttpStatus.CREATED);
    }

    @PatchMapping(path = "/{id}/status")
    @Operation(summary = "Update status an order")
    @ApiResponses(value = {@ApiResponse(code =   500, message = "Internal server error"),
            @ApiResponse(code =   200, message = "Ok", response = OrderResponse.class)})
    public ResponseEntity<String> update(@PathVariable String id) {
        orderService.findByOrderIdStatusEqualsUnrealized(id);
        return ResponseEntity.ok().body(null);
    }


}
