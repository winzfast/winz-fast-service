package com.test.winzfast.converter;

import com.test.winzfast.dto.response.ProductResponseDTO;
import com.test.winzfast.model.Product;
import com.test.winzfast.model.Specification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProductConverter {

    public ProductResponseDTO getProductResponseDTO(Product product) {
        ProductResponseDTO responseDTO = new ProductResponseDTO();
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
