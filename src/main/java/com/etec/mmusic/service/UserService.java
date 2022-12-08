package com.etec.mmusic.service;

import com.etec.mmusic.controller.request.CreateUserRequest;
import com.etec.mmusic.controller.response.UserResponse;
import com.etec.mmusic.entity.UserEntity;
import com.etec.mmusic.exception.ResourceNotFoundException;
import com.etec.mmusic.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class UserService implements IUserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    PasswordEncoder encoder;

    public List<UserResponse> findAll() {

        List<UserEntity> userEntityList = userRepository.findAll();
        return userEntityList
                .stream()
                .map(user -> modelMapper.map(user, UserResponse.class))
                .collect(Collectors.toList());
    }

    @Override
    public UserResponse findById(String id) {
        UserEntity userEntity = userRepository.findUserEntityById(UUID.fromString(id));
        if (userEntity == null) {
            throw new ResourceNotFoundException("Resource not found");
        }

        return modelMapper.map(userEntity, UserResponse.class);
    }

    public UserResponse save(CreateUserRequest createUserRequest) {


        UserEntity userEntity = UserEntity.builder()
                .username(createUserRequest.getUsername())
                .email(createUserRequest.getEmail())
                .password(encoder.encode(createUserRequest.getPassword()))
                .status(createUserRequest.getStatus())
                .timestamp(new Date().toInstant().atZone(ZoneId.of("America/Sao_Paulo")).toLocalDateTime())
                .build();

        UserEntity userEntityReturn = userRepository.save(userEntity);

        return modelMapper.map(userEntityReturn, UserResponse.class);
    }


}
