package com.test.winzfast.converter.user;

import com.test.winzfast.model.User;
import com.test.winzfast.dto.payload.response.user.RegisterResponse;

public class RegisterConverter {
    public static RegisterResponse registerEntityToDto(User user) {
        RegisterResponse registerResponse = new RegisterResponse();
        registerResponse.setUsername(user.getUsername());
        registerResponse.setPassword(user.getPassword());
        registerResponse.setEmail(user.getEmail());
        return registerResponse;
    }
}
