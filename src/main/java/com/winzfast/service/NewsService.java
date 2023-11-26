package com.winzfast.service;

import com.winzfast.dto.ProductDTO;
import com.winzfast.dto.payload.request.product.NewsRequest;
import com.winzfast.dto.payload.response.product.NewsResponse;
import com.winzfast.dto.payload.response.Response;
import com.winzfast.dto.payload.response.product.ProductResponse;
import com.winzfast.entity.Product;

import java.util.List;
import java.util.Optional;

public interface NewsService {

    ProductDTO getNewsById(Long id);

    NewsResponse createNews(NewsRequest newsRequest);

    Response delete(Long id);


}
