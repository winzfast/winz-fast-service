package com.winzfast.converter.product;


import com.winzfast.dto.payload.response.product.ProductResponse;
import com.winzfast.model.Product;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

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
//        productResponse.setDelete(product.isDelete());
        productResponse.setCategory(product.getCategory().getId());
        productResponse.setUser(product.getUser().getId());
        return productResponse;
    }

    public List<ProductResponse> getProductListDTO(List<Product> products) {
        List<ProductResponse> productResponses = new ArrayList<>();
        for (Product product : products) {
            productResponses.add(getProductResponseDTO(product));
        }
        return productResponses;
    }
}
