package com.winzfast.service;

import com.winzfast.dto.payload.request.product.ProductRequest;
import com.winzfast.dto.payload.request.product.SearchRequest;
import com.winzfast.dto.payload.response.product.CommonResponse;
import com.winzfast.dto.payload.response.product.ProductResponse;
import com.winzfast.dto.payload.response.product.Response;
import com.winzfast.model.Product;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ProductService {
    ProductResponse updateProduct(Long id, ProductRequest productRequest);

    boolean exists(Long id);

    CommonResponse<ProductResponse> searchAll(String title, Pageable pageable);

    Response delete(Long id);

    Response increaseViews(Long id);
}
