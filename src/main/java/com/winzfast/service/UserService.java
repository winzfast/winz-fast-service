package com.winzfast.service;

import com.winzfast.dto.UserDTO;
import com.winzfast.exception.DuplicatedDataException;
import com.winzfast.exception.InvalidInputException;
import com.winzfast.payload.request.LoginRequest;
import com.winzfast.payload.request.RegisterRequest;
import com.winzfast.payload.request.ResetPasswordRequest;
import com.winzfast.payload.response.LoginResponse;
import com.winzfast.payload.response.RegisterResponse;
import com.winzfast.payload.response.ResetPasswordResponse;

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
