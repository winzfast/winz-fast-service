package com.test.winzfast.service;


import com.test.winzfast.dto.payload.request.product.SpecificationRequest;
import com.test.winzfast.dto.payload.response.product.SpecificationResponse;
import com.test.winzfast.model.Specification;

import java.util.List;

/**
 * @author ADMIN
 */
public interface SpecificationService {
    SpecificationResponse createSpecification(SpecificationRequest specificationRequest);

    SpecificationResponse updateSpecification(Long id, SpecificationRequest specificationRequest);

    List<Specification> sort(String sortBy, String brand, String carModel);
}
