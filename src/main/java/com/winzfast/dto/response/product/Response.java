package com.winzfast.dto.response.product;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Response {
    private String message;
    private Object data;
    private int status;

    public Response(String s, Object o, int value, boolean b) {

    }
}
