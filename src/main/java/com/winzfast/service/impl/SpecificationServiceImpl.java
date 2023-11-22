package com.winzfast.service.impl;

import com.winzfast.converter.SpecificationConverter;
import com.winzfast.dto.request.SpecificationRequestDTO;
import com.winzfast.dto.response.SpecificationResponseDTO;
import com.winzfast.model.Product;
import com.winzfast.model.Specification;
import com.winzfast.repository.ProductRepository;
import com.winzfast.repository.SpecificationRepository;
import com.winzfast.service.ProductService;
import com.winzfast.service.SpecificationService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class SpecificationServiceImpl implements SpecificationService {

    private final SpecificationConverter specificationConverter;
    private final SpecificationRepository specificationRepository;
    private final ProductRepository productRepository;
    private final ProductService productService;

    @Override
    public SpecificationResponseDTO createSpecification(SpecificationRequestDTO specificationRequestDTO) {
//        if (!productService.exists(specificationRequestDTO.getProduct().getId())) {
//            throw new RuntimeException("Product not found");
//        }
        Specification specification = new Specification();
        return getSpecificationResponseDTO(specificationRequestDTO, specification);
    }

    @Override
    public SpecificationResponseDTO updateSpecification(Long id, SpecificationRequestDTO specificationRequestDTO) {
        Optional<Specification> optionalSpecification = specificationRepository.findById(id);
        if (optionalSpecification.isEmpty()) {
            throw new RuntimeException("Specification not found with id" + id);
        }
        Specification specification = optionalSpecification.get();
        return getSpecificationResponseDTO(specificationRequestDTO, specification);

    }

    private SpecificationResponseDTO getSpecificationResponseDTO(SpecificationRequestDTO specificationRequestDTO, Specification specification) {
        specification.setBrand(specificationRequestDTO.getBrand());
        specification.setCarModel(specificationRequestDTO.getCarModel());
        specification.setGear(specificationRequestDTO.getGear());
        specification.setFuel(specificationRequestDTO.getFuel());
        specification.setEngine(specificationRequestDTO.getEngine());
        specification.setOrigin(specificationRequestDTO.getOrigin());
        specification.setNumberOfSeat(specificationRequestDTO.getNumberOfSeat());
        specification.setYear(specificationRequestDTO.getYear());
        specification.setDelete(specificationRequestDTO.isDelete());
        Long productId = specificationRequestDTO.getProduct();
        Product product = productRepository.findById(productId).orElse(null);
        specification.setProduct(product);
        specificationRepository.save(specification);
        return specificationConverter.getSpecificationResponseDTO(specification);
    }

    @Override
    public List<Specification> sort(String sortBy, String brand, String carModel) {

        List<Specification> specifications = new ArrayList<>();
        if (sortBy != null && sortBy.equals("brand")) {
            specifications = specificationRepository.findAll(Sort.by("brand"));
        }
        if (sortBy != null && sortBy.equals("carModel")) {
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
