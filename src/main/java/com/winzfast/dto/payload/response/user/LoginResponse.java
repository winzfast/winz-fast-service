
package com.winzfast.dto.payload.response.user;



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
