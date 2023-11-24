package com.winzfast.service;


import com.winzfast.dto.request.product.SpecificationRequest;
import com.winzfast.dto.response.product.SpecificationResponse;
import com.winzfast.model.Specification;

import java.util.List;

public interface SpecificationService {
    SpecificationResponse createSpecification(SpecificationRequest specificationRequest);

    SpecificationResponse updateSpecification(Long id, SpecificationRequest specificationRequest);

    List<Specification> sort(String sortBy, String brand, String carModel);
}
