package com.test.winzfast.service.impl;

import com.test.winzfast.converter.product.SpecificationConverter;
import com.test.winzfast.dto.payload.request.product.SpecificationRequest;
import com.test.winzfast.dto.payload.response.product.SpecificationResponse;
import com.test.winzfast.model.Specification;
import com.test.winzfast.repository.ProductRepository;
import com.test.winzfast.repository.SpecificationRepository;
import com.test.winzfast.service.SpecificationService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * @author ADMIN
 */
@Service
@AllArgsConstructor
public class SpecificationServiceImpl implements SpecificationService {

    private final SpecificationConverter specificationConverter;
    private final SpecificationRepository specificationRepository;
    private final ProductRepository productRepository;

    @Override
    public SpecificationResponse createSpecification(SpecificationRequest specificationRequest) {
        Specification specification = new Specification();

        specification.setBrand(specificationRequest.getBrand());
        specification.setCarModel(specificationRequest.getCarModel());
        specification.setEngine(specificationRequest.getEngine());
        specification.setYear(specificationRequest.getYear());
        specification.setFuel(specificationRequest.getFuel());
        specification.setOrigin(specificationRequest.getOrigin());
        specification.setGear(specificationRequest.getGear());
        specification.setNumberOfSeat(specificationRequest.getNumberOfSeat());
        specification.setDelete(specificationRequest.isDelete());


        Specification savedSpecification = specificationRepository.save(specification);


        return getSpecificationResponseDTO(savedSpecification);
    }
    public SpecificationResponse getSpecificationResponseDTO(Specification specification) {
        SpecificationResponse response = new SpecificationResponse();
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

    @Override
    public SpecificationResponse updateSpecification(Long id, SpecificationRequest specificationRequest) {
        Optional<Specification> optionalSpecification = specificationRepository.findById(id);
        if (optionalSpecification.isEmpty()) {
            throw new RuntimeException("Specification not found with id" + id);
        }
        Specification specification = optionalSpecification.get();
        return getSpecificationResponse(specificationRequest, specification);

    }

    private SpecificationResponse getSpecificationResponse(SpecificationRequest specificationRequest, Specification specification) {
        specification.setBrand(specificationRequest.getBrand());
        specification.setCarModel(specificationRequest.getCarModel());
        specification.setGear(specificationRequest.getGear());
        specification.setFuel(specificationRequest.getFuel());
        specification.setEngine(specificationRequest.getEngine());
        specification.setOrigin(specificationRequest.getOrigin());
        specification.setNumberOfSeat(specificationRequest.getNumberOfSeat());
        specification.setYear(specificationRequest.getYear());
        specification.setDelete(specificationRequest.isDelete());

        Long productId = specificationRequest.getProduct();
        productRepository.findById(productId).ifPresent(product -> specification.setProducts(List.of(product)));

        specificationRepository.save(specification);

        return specificationConverter.convertToSpecificationResponse(specification);
    }


    @Override
    public List<Specification> sort(String sortBy, String brand, String carModel) {

        List<Specification> specifications = new ArrayList<>();
        if ("brand".equals(sortBy)) {
            specifications = specificationRepository.findAll(Sort.by("brand"));
        }
        if ("carModel".equals(sortBy)) {
            specifications = specificationRepository.findAll(Sort.by("carModel"));
        }
        if (brand != null) {
            specifications = specificationRepository.findByBrand(brand);
        }
        if (carModel != null) {
            specifications = specificationRepository.findByCarModel(carModel);
        }
        return specifications;
    }


}
