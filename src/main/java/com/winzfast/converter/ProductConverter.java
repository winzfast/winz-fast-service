package com.winzfast.converter;

import com.winzfast.dto.response.product.ProductResponse;
import com.winzfast.model.Product;
import org.springframework.stereotype.Component;

@Component
public class ProductConverter {

    public ProductResponse getProductResponseDTO(Product product) {
        ProductResponse responseDTO = new ProductResponse();
        responseDTO.setId(product.getId());
        responseDTO.setTitle(product.getTitle());
        responseDTO.setThumbnail(product.getThumbnail());
        responseDTO.setPrice(product.getPrice());
        responseDTO.setView(product.getView());
        responseDTO.setProductDate(product.getProductDate());
        responseDTO.setDelete(product.isDelete());
        responseDTO.setCategory(product.getCategory().getId());
        responseDTO.setUser(product.getUser().getId());
        return responseDTO;
    }
}
