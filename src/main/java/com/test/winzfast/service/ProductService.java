package com.test.winzfast.service;


import com.test.winzfast.dto.payload.request.product.ProductRequest;
import com.test.winzfast.dto.payload.request.product.SearchRequest;
import com.test.winzfast.dto.payload.response.product.ProductResponse;
import com.test.winzfast.dto.payload.response.product.Response;

public interface ProductService {

    ProductResponse createProduct(ProductRequest productRequest);

    ProductResponse updateProduct(Long id, ProductRequest productRequest);
    boolean exists(Long id);
    Response delete(Long id);
    Response search(SearchRequest searchRequestDTO);
    Response increaseViews(Long id);
}
