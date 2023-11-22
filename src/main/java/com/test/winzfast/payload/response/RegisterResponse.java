package com.test.winzfast.payload.response;

import lombok.Data;

@Data
public class RegisterResponse {
    private String username;
    private String password;
    private String email;
}
