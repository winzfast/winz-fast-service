package com.winzfast.dto.response.product;


import com.winzfast.model.Product;
import lombok.Data;

@Data
public class CategoryResponse {
    private Long id;
    private String logo;
    private String name;
    private Product product;
    private String message;
}
