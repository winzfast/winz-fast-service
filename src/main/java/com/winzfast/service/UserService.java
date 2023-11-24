package com.winzfast.service;

import com.winzfast.dto.UserDTO;
import com.winzfast.exception.DuplicatedDataException;
import com.winzfast.exception.InvalidInputException;
import com.winzfast.dto.request.user.LoginRequest;
import com.winzfast.dto.request.user.RegisterRequest;
import com.winzfast.dto.request.user.ResetPasswordRequest;
import com.winzfast.dto.response.user.LoginResponse;
import com.winzfast.dto.response.user.RegisterResponse;
import com.winzfast.dto.response.user.ResetPasswordResponse;

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
