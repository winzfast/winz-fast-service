package com.winzfast.converter.user;

import com.winzfast.dto.payload.response.user.RegisterResponse;
import com.winzfast.entity.User;


public class RegisterConverter {
    public static RegisterResponse registerEntityToDto(User user) {
        RegisterResponse registerResponse = new RegisterResponse();
        registerResponse.setUsername(user.getUsername());
        registerResponse.setPassword(user.getPassword());
        registerResponse.setEmail(user.getEmail());
        return registerResponse;
    }
}
