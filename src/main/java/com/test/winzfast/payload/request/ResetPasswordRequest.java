package com.test.winzfast.payload.request;

import lombok.Data;

@Data
public class ResetPasswordRequest {

    private String username;
    private String email;
    private String newPassword;
}
