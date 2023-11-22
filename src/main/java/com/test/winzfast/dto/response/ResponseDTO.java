package com.test.winzfast.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseDTO {
    private String message;
    private Object data;
    private int status;

    public ResponseDTO(String s, Object o, int value, boolean b) {

    }
}
