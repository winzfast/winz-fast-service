package com.winzfast.controller;


import com.winzfast.dto.request.SpecificationRequestDTO;
import com.winzfast.dto.response.SpecificationResponseDTO;
import com.winzfast.model.Specification;
import com.winzfast.repository.ProductRepository;
import com.winzfast.service.SpecificationService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/specifications")
@AllArgsConstructor
public class
SpecificationRestController {
    private final SpecificationService specificationService;
    private final ProductRepository productRepository;
    @PostMapping("/create")
    public ResponseEntity<?> createSpecification(@RequestBody SpecificationRequestDTO specificationRequestDTO){
        try {
            SpecificationResponseDTO specificationResponseDTO= specificationService.createSpecification(specificationRequestDTO);
            return ResponseEntity.status(HttpStatus.CREATED).body(specificationResponseDTO.getId()+"Create Specification Successfully!");
        } catch (RuntimeException e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Create Failed");
        }

    }
    @PutMapping("/update/{id}")
    public ResponseEntity<SpecificationResponseDTO> updateProduct(@PathVariable Long id, @RequestBody SpecificationRequestDTO specificationRequestDTO) {
        SpecificationResponseDTO specificationResponseDTO = specificationService.updateSpecification(id,specificationRequestDTO);
        if (specificationRequestDTO != null) {
            return new ResponseEntity<>(specificationResponseDTO, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @GetMapping("/sort")
    public ResponseEntity<List<Specification>> getSorted(@RequestParam(required = false) String sortBy,
                                                         @RequestParam(required = false, name = "brand") String brand,
                                                         @RequestParam(required = false, name = "carModel") String carModel) {
        List<Specification> sorted = specificationService.sort(sortBy, brand, carModel);
        return new ResponseEntity<>(sorted, HttpStatus.OK);
    }

}
