package com.winzfast.dto.response;


import com.winzfast.model.Product;
import lombok.Data;

@Data
public class CategoryResponseDTO {
    private Long id;
    private String logo;
    private String name;
    private Product product;
    private String message;
}
