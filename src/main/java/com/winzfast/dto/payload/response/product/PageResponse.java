package com.winzfast.dto.payload.response.product;

import lombok.Data;

import java.util.List;

@Data
public class PageResponse<ProductResponse> {
    private List<ProductResponse> content;
    private int page;
    private int size;
    private long totalElements;
    private long totalPage;
}
