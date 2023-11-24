package com.winzfast.dto.response.user;

import lombok.Data;

@Data
public class RegisterResponse {
    private String username;
    private String password;
    private String email;
}
