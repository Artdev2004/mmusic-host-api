package com.etec.mmusic.service;

import com.etec.mmusic.controller.request.CreateUserRequest;
import com.etec.mmusic.controller.response.UserResponse;

import java.util.List;


public interface IUserService {

    public List<UserResponse> findAll();
    public UserResponse findById(String id);
    public UserResponse save(CreateUserRequest request);

}
