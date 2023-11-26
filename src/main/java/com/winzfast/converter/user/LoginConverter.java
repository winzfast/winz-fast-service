package com.winzfast.converter.user;

import com.winzfast.dto.payload.response.user.LoginResponse;
import com.winzfast.entity.User;


public class LoginConverter {
    public static LoginResponse loginEntityToDto(User user) {
        LoginResponse loginResponse = new LoginResponse();
        loginResponse.setUsername(user.getUsername());
        return loginResponse;
    }
}
