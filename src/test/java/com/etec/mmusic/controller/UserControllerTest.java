package com.etec.mmusic.controller;

import com.etec.mmusic.controller.response.UserResponse;
import com.etec.mmusic.service.UserService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.when;


class UserControllerTest {


    UserController userController;

    UserService userService;

    void findAll() throws Exception {

        UserResponse userResponse1 = UserResponse.builder()
                .id("id")
                .email("email@gmail.com")
                .username("username")
                .status("status")
                .build();

        when(List.of(userResponse1)).thenReturn(List.of(userResponse1));

        List<UserResponse> result = (List<UserResponse>) userController.findAll();

        assertThat(result.size()).isEqualTo(1);


    }

}