package com.winzfast.dto.response.user;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class LoginResponse {
    private String username;
    private String password;
}
