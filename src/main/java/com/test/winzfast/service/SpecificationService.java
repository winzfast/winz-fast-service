package com.test.winzfast.service;


import com.test.winzfast.dto.request.SpecificationRequestDTO;
import com.test.winzfast.dto.response.SpecificationResponseDTO;
import com.test.winzfast.model.Specification;

import java.util.List;

public interface SpecificationService {
    SpecificationResponseDTO createSpecification(SpecificationRequestDTO specificationRequestDTO);

    SpecificationResponseDTO updateSpecification(Long id, SpecificationRequestDTO specificationRequestDTO);

    List<Specification> sort(String sortBy, String brand, String carModel);
}
