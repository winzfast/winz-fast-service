package com.winzfast.converter;

import com.winzfast.model.User;
import com.winzfast.dto.response.user.LoginResponse;

public class LoginConverter {
    public static LoginResponse loginEntityToDto(User user) {
        LoginResponse loginResponse = new LoginResponse();
        loginResponse.setUsername(user.getUsername());
        return loginResponse;
    }
}
