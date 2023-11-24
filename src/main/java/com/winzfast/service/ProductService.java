package com.winzfast.service;


import com.winzfast.dto.request.product.ProductRequest;
import com.winzfast.dto.request.product.SearchRequest;
import com.winzfast.dto.response.product.ProductResponse;
import com.winzfast.dto.response.product.Response;

public interface ProductService {

    ProductResponse createProduct(ProductRequest productRequest);

    ProductResponse updateProduct(Long id, ProductRequest productRequest);
    boolean exists(Long id);
    Response delete(Long id);
    Response search(SearchRequest searchRequest);
    Response increaseViews(Long id);
}
