package com.test.winzfast.converter.product;

import com.test.winzfast.dto.payload.response.product.ProductResponse;
import com.test.winzfast.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author ADMIN
 */
@Component
public class ProductConverter {

    public ProductResponse getProductResponseDTO(Product product) {
        ProductResponse response = new ProductResponse();
        response.setId(product.getId());
        response.setTitle(product.getTitle());
        response.setThumbnail(product.getThumbnail());
        response.setPrice(product.getPrice());
        response.setView(product.getView());
        response.setProductDate(product.getProductDate());
        response.setDelete(product.isDelete());
        response.setCategory(product.getCategory().getId());
        response.setUser(product.getUser().getId());
        return response;
    }
}
