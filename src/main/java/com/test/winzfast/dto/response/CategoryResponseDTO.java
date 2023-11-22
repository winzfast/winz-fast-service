package com.test.winzfast.dto.response;


import com.test.winzfast.model.Product;
import lombok.Data;

@Data
public class CategoryResponseDTO {
    private Long id;
    private String logo;
    private String name;
    private Product product;
    private String message;
}
