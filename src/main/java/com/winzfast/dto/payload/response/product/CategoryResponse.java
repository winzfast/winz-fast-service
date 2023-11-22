package com.winzfast.dto.payload.response.product;


import com.winzfast.model.Product;
import lombok.Data;

/**
 * @author ADMIN
 */
@Data
public class CategoryResponse {
    private Long id;
    private String logo;
    private String name;
    private Product product;
    private String message;
}
