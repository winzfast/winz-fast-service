package com.test.winzfast.converter.product;


import com.test.winzfast.dto.payload.response.product.SpecificationResponse;
import com.test.winzfast.model.Specification;
import org.springframework.stereotype.Component;

/**
 * @author ADMIN
 */
@Component
public class SpecificationConverter {
    public SpecificationResponse convertToSpecificationResponse(Specification specification) {
        SpecificationResponse response = new SpecificationResponse();
        response.setId(specification.getId());
        response.setBrand(specification.getBrand());
        response.setCarModel(specification.getCarModel());
        response.setEngine(specification.getEngine());
        response.setYear(specification.getYear());
        response.setFuel(specification.getFuel());
        response.setOrigin(specification.getOrigin());
        response.setGear(specification.getGear());
        response.setNumberOfSeat(specification.getNumberOfSeat());
        response.setDelete(specification.isDelete());

        return response;
    }
}
