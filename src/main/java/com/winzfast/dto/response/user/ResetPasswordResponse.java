package com.winzfast.dto.response.user;

import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
public class ResetPasswordResponse {

    private String message;

    public ResetPasswordResponse(String message, HttpStatus httpStatus) {
        this.message = message;
    }
}
