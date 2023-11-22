package com.test.winzfast.dto.payload.response.user;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

/**
 * @author ADMIN
 */
@Data
public class LoginResponse {
    private String username;
    private String password;
    private String email;
}
