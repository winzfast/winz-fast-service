package com.winzfast.dto.payload.request.user;

import lombok.Data;

/**
 * @author ADMIN
 */
@Data
public class ResetPasswordRequest {

    private String username;
    private String email;
    private String newPassword;

}
