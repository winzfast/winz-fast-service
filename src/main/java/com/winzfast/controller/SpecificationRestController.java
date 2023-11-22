package com.winzfast.controller;

import com.winzfast.dto.payload.request.product.SpecificationRequest;
import com.winzfast.dto.payload.response.product.SpecificationResponse;
import com.winzfast.model.Specification;
import com.winzfast.service.SpecificationService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * @author ADMIN
 */
@RestController
@RequestMapping("/api/specifications")
@CrossOrigin(origins = "*")
@AllArgsConstructor
public class SpecificationRestController {

    private final SpecificationService specificationService;

    @PostMapping("/create")

    public ResponseEntity<String> createSpecification(@RequestBody SpecificationRequest specificationRequest){

        try {
            SpecificationResponse specificationResponse= specificationService.createSpecification(specificationRequest);
            return ResponseEntity.status(HttpStatus.CREATED).body(specificationResponse.getId()+"Create Specification Successfully!");
        } catch (RuntimeException e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Create Failed");
        }

    }
    @PutMapping("/update/{id}")
    public ResponseEntity<SpecificationResponse> updateProduct(@PathVariable Long id, @RequestBody SpecificationRequest specificationRequest) {
        SpecificationResponse specificationResponseDTO = specificationService.updateSpecification(id,specificationRequest);
        if (specificationRequest != null) {
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
