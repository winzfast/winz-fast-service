package com.test.winzfast.converter;

import com.test.winzfast.model.User;
import com.test.winzfast.payload.response.LoginResponse;

public class LoginConverter {
    public static LoginResponse loginEntityToDto(User user) {
        LoginResponse loginResponse = new LoginResponse();
        loginResponse.setUsername(user.getUsername());
        return loginResponse;
    }
}
