package com.test.winzfast.service.impl;

import com.test.winzfast.converter.product.SpecificationConverter;
import com.test.winzfast.dto.payload.request.product.SpecificationRequest;
import com.test.winzfast.dto.payload.response.product.SpecificationResponse;
import com.test.winzfast.model.Product;
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
//        if (!productService.exists(specificationRequestDTO.getProduct().getId())) {
//            throw new RuntimeException("Product not found");
//        }
        Specification specification = new Specification();
        return getSpecificationResponse(specificationRequest, specification);
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
        Product product = productRepository.findById(productId).orElse(null);
        specification.setProduct(product);
        specificationRepository.save(specification);
        return specificationConverter.getSpecificationResponseDTO(specification);
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
