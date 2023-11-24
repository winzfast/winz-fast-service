package com.winzfast.service;

import com.winzfast.dto.UserDTO;
import com.winzfast.dto.payload.request.user.LoginRequest;
import com.winzfast.dto.payload.request.user.RegisterRequest;
import com.winzfast.dto.payload.request.user.ResetPasswordRequest;
import com.winzfast.dto.payload.response.user.LoginResponse;
import com.winzfast.dto.payload.response.user.RegisterResponse;
import com.winzfast.dto.payload.response.user.ResetPasswordResponse;
import com.winzfast.exception.DuplicatedDataException;
import com.winzfast.exception.InvalidInputException;


import java.util.Optional;

public interface UserService {

    //CRUD
    Iterable<UserDTO> findAll();

    Optional<UserDTO> findById(Long id);

    void save(UserDTO userDto);

    void delete(Long id);

    //Add-ons
    LoginResponse login(LoginRequest loginRequest) throws InvalidInputException;

    RegisterResponse register(RegisterRequest registerRequest) throws DuplicatedDataException;

    ResetPasswordResponse resetPassword(ResetPasswordRequest resetPasswordRequest);

    UserDTO getUserById(Long id);
    Iterable<UserDTO> findUser(String username);
}
