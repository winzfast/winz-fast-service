package com.winzfast.service;

import com.winzfast.dto.ProductDTO;
import com.winzfast.dto.payload.request.product.ProductRequest;
import com.winzfast.dto.payload.response.product.CommonResponse;
import com.winzfast.dto.payload.response.product.ProductResponse;
import com.winzfast.dto.payload.response.Response;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ProductService {
    Iterable<ProductDTO> getAll();

    ProductResponse updateProduct(Long id, ProductRequest productRequest);

    boolean exists(Long id);

//    CommonResponse<ProductResponse> getAllProducts(Pageable pageable);
//
//    CommonResponse<ProductResponse> filterProductByPrice(Integer minPrice, Integer maxPrice, Pageable pageable);
//
//    CommonResponse<ProductResponse> searchAll(String title, Pageable pageable);

    List<ProductResponse> getProductByCategoryId(Long id);

    Response increaseViews(Long id);
}
