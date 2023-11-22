package com.test.winzfast.payload.response;

import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
public class ResetPasswordResponse {

    private String message;

    public ResetPasswordResponse(String message, HttpStatus httpStatus) {
        this.message = message;
    }
}
