package com.winzfast.converter;

import com.winzfast.model.User;
import com.winzfast.payload.response.RegisterResponse;

public class RegisterConverter {
    public static RegisterResponse registerEntityToDto(User user) {
        RegisterResponse registerResponse = new RegisterResponse();
        registerResponse.setUsername(user.getUsername());
        registerResponse.setPassword(user.getPassword());
        registerResponse.setEmail(user.getEmail());
        return registerResponse;
    }
}
