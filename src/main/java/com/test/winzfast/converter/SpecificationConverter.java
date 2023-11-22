package com.test.winzfast.converter;


import com.test.winzfast.dto.response.SpecificationResponseDTO;
import com.test.winzfast.model.Product;
import com.test.winzfast.model.Specification;
import org.springframework.stereotype.Component;

@Component
public class SpecificationConverter {
    public SpecificationResponseDTO getSpecificationResponseDTO(Specification specification){
        SpecificationResponseDTO specificationResponseDTO =new SpecificationResponseDTO();
        specificationResponseDTO.setId(specification.getId());
        specificationResponseDTO.setBrand(specification.getBrand());
        specificationResponseDTO.setCarModel(specification.getCarModel());
        specificationResponseDTO.setEngine(specification.getEngine());
        specificationResponseDTO.setYear(specification.getYear());
        specificationResponseDTO.setFuel(specification.getFuel());
        specificationResponseDTO.setOrigin(specification.getOrigin());
        specificationResponseDTO.setGear(specification.getGear());
        specificationResponseDTO.setDelete(specification.isDelete());
        specificationResponseDTO.setNumberOfSeat(specification.getNumberOfSeat());
        specificationResponseDTO.setProduct(specification.getProduct().getId());
        return specificationResponseDTO;
    }

}
