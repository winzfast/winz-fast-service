package com.test.winzfast.dto.payload.request.user;

import lombok.Data;

/**
 * @author ADMIN
 */
@Data
public class LoginRequest {

    private String username;
    private String password;

}
