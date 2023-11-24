package com.winzfast.service;

import com.winzfast.dto.payload.request.product.ProductRequest;
import com.winzfast.dto.payload.response.product.CommonResponse;
import com.winzfast.dto.payload.response.product.ProductResponse;
import com.winzfast.dto.payload.response.Response;
import org.springframework.data.domain.Pageable;

public interface ProductService {
    ProductResponse updateProduct(Long id, ProductRequest productRequest);

    boolean exists(Long id);

    CommonResponse<ProductResponse> searchAll(String title, Pageable pageable);

    Response increaseViews(Long id);
}
