package com.winzfast.converter;


import com.winzfast.dto.payload.response.product.ProductResponse;
import com.winzfast.model.Product;
import org.springframework.stereotype.Component;

@Component
public class ProductConverter {

    public ProductResponse getProductResponseDTO(Product product) {
        ProductResponse productResponse = new ProductResponse();
        productResponse.setId(product.getId());
        productResponse.setTitle(product.getTitle());
        productResponse.setThumbnail(product.getThumbnail());
        productResponse.setPrice(product.getPrice());
        productResponse.setView(product.getView());
        productResponse.setProductDate(product.getProductDate());
        productResponse.setDelete(product.isDelete());
        productResponse.setCategory(product.getCategory().getId());
        productResponse.setUser(product.getUser().getId());
        return productResponse;
    }
}
