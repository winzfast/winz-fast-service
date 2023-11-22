package com.test.winzfast.payload.response;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class LoginResponse {
    private String username;
    private String password;
    private String email;
}
