package com.etec.mmusic.controller;

import com.etec.mmusic.controller.request.CreateUserRequest;
import com.etec.mmusic.controller.request.LoginRequest;
import com.etec.mmusic.controller.response.OrderResponse;
import com.etec.mmusic.controller.response.UserResponse;
import com.etec.mmusic.controller.response.UserTokenResponse;
import com.etec.mmusic.security.jwt.JwtUtils;
import com.etec.mmusic.security.services.UserDetailsImpl;
import com.etec.mmusic.service.IUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseCookie;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/auth")
@Api(value = "API authentication and authorization")
public class AuthController
{

    @Autowired
    private IUserService userService;

    @Autowired
    AuthenticationManager authenticationManager;
    @Autowired
    JwtUtils jwtUtils;

    @PostMapping("/signup")
    @Operation(summary = "Registry an one User")
    @ApiResponses(value = {@ApiResponse(code =   500, message = "Internal server error"),
            @ApiResponse(code =   400, message = "Bad request"),
            @ApiResponse(code =   404, message = "Resource not found"),
            @ApiResponse(code =   201, message = "Created", response = OrderResponse.class)})
    public ResponseEntity<UserResponse> save(@RequestBody @Valid CreateUserRequest createUserRequest) {
        return new ResponseEntity<>(userService.save(createUserRequest), HttpStatus.CREATED);
    }

    @PostMapping("/signin")
    @Operation(summary = "Login an one User")
    @ApiResponses(value = {@ApiResponse(code =   500, message = "Internal server error"),
            @ApiResponse(code =   400, message = "Bad request"),
            @ApiResponse(code =   404, message = "Resource not found"),
            @ApiResponse(code =   201, message = "Created", response = OrderResponse.class)})
    public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {

        Authentication authentication = authenticationManager
                .authenticate(new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = String.format("Bearer %s", jwtUtils.generateJwtToken(authentication));

        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();

        List<String> roles = userDetails.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority)
                .collect(Collectors.toList());


        UserTokenResponse userTokenResponse = UserTokenResponse.builder()
                .accessToken(jwt)
                .id(userDetails.getId().toString())
                .username(userDetails.getUsername())
                .status(roles.get(0))
                .build();

        return ResponseEntity.ok()
                .body(userTokenResponse);
    }
}
