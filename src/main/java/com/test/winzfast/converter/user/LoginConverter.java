package com.test.winzfast.converter.user;

import com.test.winzfast.model.User;
import com.test.winzfast.dto.payload.response.user.LoginResponse;

public class LoginConverter {
    public static LoginResponse loginEntityToDto(User user) {
        LoginResponse loginResponse = new LoginResponse();
        loginResponse.setUsername(user.getUsername());
        return loginResponse;
    }
}
