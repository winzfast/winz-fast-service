
package com.winzfast.dto.payload.response.user;


import lombok.Data;

/**
 * @author ADMIN
 */
@Data
public class RegisterResponse {
    private String username;
    private String password;
    private String email;
}
