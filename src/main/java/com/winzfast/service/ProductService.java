package com.winzfast.service;


import com.winzfast.dto.request.ProductRequestDTO;
import com.winzfast.dto.request.SearchRequestDTO;
import com.winzfast.dto.response.ProductResponseDTO;
import com.winzfast.dto.response.ResponseDTO;

public interface ProductService {

    ProductResponseDTO createProduct(ProductRequestDTO productRequestDTO);

    ProductResponseDTO updateProduct(Long id, ProductRequestDTO productRequestDTO);
    boolean exists(Long id);
    ResponseDTO delete(Long id);
    ResponseDTO search(SearchRequestDTO searchRequestDTO);
    ResponseDTO increaseViews(Long id);
}
