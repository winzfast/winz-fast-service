package com.winzfast.dto.payload.response.product;

import lombok.Data;

@Data
public class CommonResponse<ProductResponse> {
    private String message;
    private PageResponse<ProductResponse> data;
    private boolean status;
}
