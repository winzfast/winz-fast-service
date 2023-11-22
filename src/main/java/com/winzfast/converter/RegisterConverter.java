package com.winzfast.converter;

import com.winzfast.dto.payload.response.user.RegisterResponse;
import com.winzfast.model.User;
import org.springframework.stereotype.Component;


public class RegisterConverter {
    public static RegisterResponse registerEntityToDto(User user) {
        RegisterResponse registerResponse = new RegisterResponse();
        registerResponse.setUsername(user.getUsername());
        registerResponse.setPassword(user.getPassword());
        registerResponse.setEmail(user.getEmail());
        return registerResponse;
    }
}
