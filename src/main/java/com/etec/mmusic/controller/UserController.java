package com.etec.mmusic.controller;

import com.etec.mmusic.controller.response.OrderResponse;
import com.etec.mmusic.controller.response.UserResponse;
import com.etec.mmusic.service.IUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/users")
@Api(value = "API REST of Users")
public class UserController {

    @Autowired
    private IUserService userService;

    @GetMapping
    @Operation(summary = "Return an list of users")
    @ApiResponses(value = {@ApiResponse(code =   500, message = "Internal server error"),
            @ApiResponse(code =   200, message = "Ok", response = OrderResponse.class)})
    public ResponseEntity<List<UserResponse>> findAll() {
        return ResponseEntity.ok(userService.findAll());
    }

    @GetMapping(path = {"/{id}"})
    @Operation(summary = "Return an user registry")
    @ApiResponses(value = {@ApiResponse(code =   500, message = "Internal server error"),
            @ApiResponse(code =   200, message = "Ok", response = OrderResponse.class)})
    public ResponseEntity<UserResponse> findById(@PathVariable String id) {
        return ResponseEntity.ok(userService.findById(id));
    }

}
