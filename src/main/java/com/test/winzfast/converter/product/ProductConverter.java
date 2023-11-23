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

    public ProductResponse convertToProductResponse(Product product) {
        ProductResponse productResponse = new ProductResponse();
        productResponse.setId(product.getId());
        productResponse.setTitle(product.getTitle());
        productResponse.setThumbnail(product.getThumbnail());
        productResponse.setProductDate(product.getProductDate());
        productResponse.setPrice(product.getPrice());
        productResponse.setView(product.getView());
        productResponse.setDelete(product.isDelete());
        productResponse.setUser(product.getUser());
        productResponse.setCategory(product.getCategory());
        productResponse.setSpecification(product.getSpecification());

        return productResponse;
    }
}
