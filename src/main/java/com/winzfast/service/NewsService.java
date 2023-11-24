package com.winzfast.service;

import com.winzfast.dto.payload.request.product.NewsRequest;
import com.winzfast.dto.payload.response.product.NewsResponse;

public interface NewsService {
    NewsResponse createNews(NewsRequest newsRequest);
}
