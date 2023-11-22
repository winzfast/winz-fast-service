package com.test.winzfast.service;

import com.test.winzfast.dto.UserDTO;
import com.test.winzfast.exception.DuplicatedDataException;
import com.test.winzfast.exception.InvalidInputException;
import com.test.winzfast.dto.payload.request.user.LoginRequest;
import com.test.winzfast.dto.payload.request.user.RegisterRequest;
import com.test.winzfast.dto.payload.request.user.ResetPasswordRequest;
import com.test.winzfast.dto.payload.response.user.LoginResponse;
import com.test.winzfast.dto.payload.response.user.RegisterResponse;
import com.test.winzfast.dto.payload.response.user.ResetPasswordResponse;

import java.util.Optional;

/**
 * @author ADMIN
 */
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
