package com.winzfast.converter;


import com.winzfast.dto.response.product.SpecificationResponse;
import com.winzfast.model.Specification;
import org.springframework.stereotype.Component;

@Component
public class SpecificationConverter {
    public SpecificationResponse getSpecificationResponseDTO(Specification specification){
        SpecificationResponse specificationResponse =new SpecificationResponse();
        specificationResponse.setId(specification.getId());
        specificationResponse.setBrand(specification.getBrand());
        specificationResponse.setCarModel(specification.getCarModel());
        specificationResponse.setEngine(specification.getEngine());
        specificationResponse.setYear(specification.getYear());
        specificationResponse.setFuel(specification.getFuel());
        specificationResponse.setOrigin(specification.getOrigin());
        specificationResponse.setGear(specification.getGear());
        specificationResponse.setDelete(specification.isDelete());
        specificationResponse.setNumberOfSeat(specification.getNumberOfSeat());
        specificationResponse.setProduct(specification.getProduct().getId());
        return specificationResponse;
    }

}
