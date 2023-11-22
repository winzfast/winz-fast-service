package com.test.winzfast.service;


import com.test.winzfast.dto.request.ProductRequestDTO;
import com.test.winzfast.dto.request.SearchRequestDTO;
import com.test.winzfast.dto.response.ProductResponseDTO;
import com.test.winzfast.dto.response.ResponseDTO;

public interface ProductService {

    ProductResponseDTO createProduct(ProductRequestDTO productRequestDTO);

    ProductResponseDTO updateProduct(Long id, ProductRequestDTO productRequestDTO);
    boolean exists(Long id);
    ResponseDTO delete(Long id);
    ResponseDTO search(SearchRequestDTO searchRequestDTO);
    ResponseDTO increaseViews(Long id);
}
