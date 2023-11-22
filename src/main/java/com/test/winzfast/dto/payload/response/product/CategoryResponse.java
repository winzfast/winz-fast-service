package com.test.winzfast.dto.payload.response.product;


import com.test.winzfast.model.Product;
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
