package com.test.winzfast.service;

import com.test.winzfast.dto.UserDTO;
import com.test.winzfast.exception.DuplicatedDataException;
import com.test.winzfast.exception.InvalidInputException;
import com.test.winzfast.model.User;
import com.test.winzfast.payload.request.LoginRequest;
import com.test.winzfast.payload.request.RegisterRequest;
import com.test.winzfast.payload.request.ResetPasswordRequest;
import com.test.winzfast.payload.response.LoginResponse;
import com.test.winzfast.payload.response.RegisterResponse;
import com.test.winzfast.payload.response.ResetPasswordResponse;

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
}
