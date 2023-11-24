package com.winzfast.converter.user;

import com.winzfast.dto.payload.response.user.LoginResponse;
import com.winzfast.model.User;
import org.springframework.stereotype.Component;


public class LoginConverter {
    public static LoginResponse loginEntityToDto(User user) {
        LoginResponse loginResponse = new LoginResponse();
        loginResponse.setUsername(user.getUsername());
        return loginResponse;
    }
}
