package com.winzfast.service;




import com.winzfast.dto.payload.request.product.SpecificationRequest;
import com.winzfast.dto.payload.response.product.SpecificationResponse;
import com.winzfast.model.Specification;

import java.util.List;

/**
 * @author ADMIN
 */
public interface SpecificationService {
    SpecificationResponse updateSpecification(Long id, SpecificationRequest specificationRequest);

    List<Specification> sort(String sortBy, String brand, String carModel);
}
