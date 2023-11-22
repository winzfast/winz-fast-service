package com.winzfast.dto.payload.request.user;

import lombok.Data;

/**
 * @author ADMIN
 */
@Data
public class RegisterRequest {

    private String username;
    private String password;
    private String email;

}
