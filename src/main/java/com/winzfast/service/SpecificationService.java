package com.winzfast.service;


import com.winzfast.dto.request.SpecificationRequestDTO;
import com.winzfast.dto.response.SpecificationResponseDTO;
import com.winzfast.model.Specification;

import java.util.List;

public interface SpecificationService {
    SpecificationResponseDTO createSpecification(SpecificationRequestDTO specificationRequestDTO);

    SpecificationResponseDTO updateSpecification(Long id, SpecificationRequestDTO specificationRequestDTO);

    List<Specification> sort(String sortBy, String brand, String carModel);
}
