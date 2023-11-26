package com.winzfast.converter.product;


import com.winzfast.dto.payload.response.product.ProductResponse;
import com.winzfast.dto.payload.response.product.SpecificationResponse;
import com.winzfast.entity.Product;
import com.winzfast.entity.Specification;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
@AllArgsConstructor
public class ProductConverter {
private final SpecificationConverter specificationConverter;
    public ProductResponse getProductResponseDTO(Product product) {
        ProductResponse productResponse = new ProductResponse();
        productResponse.setId(product.getId());
        productResponse.setTitle(product.getTitle());
        productResponse.setThumbnail(product.getThumbnail());
        productResponse.setPrice(product.getPrice());
        productResponse.setView(product.getView());
        productResponse.setProductDate(product.getProductDate());
        productResponse.setCategory(product.getCategory().getId());
        productResponse.setUser(product.getUser().getId());
        return productResponse;
    }

    public ProductResponse getProductByIDToDTO(Product product, List<Specification> specifications) {
        ProductResponse productResponse = new ProductResponse();
        productResponse.setId(product.getId());
        productResponse.setTitle(product.getTitle());
        productResponse.setThumbnail(product.getThumbnail());
        productResponse.setPrice(product.getPrice());
        productResponse.setView(product.getView());
        productResponse.setProductDate(product.getProductDate());
        productResponse.setCategory(product.getCategory().getId());
        productResponse.setUser(product.getUser().getId());
        List<SpecificationResponse> specificationResponses=specifications
                .stream()
                .map(specificationConverter::getSpecificationResponseDTO)
                .toList();
        productResponse.setSpecifications(specifications);
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
