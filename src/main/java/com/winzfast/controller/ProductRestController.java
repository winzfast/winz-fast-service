package com.winzfast.controller;


import com.winzfast.dto.request.ProductRequestDTO;
import com.winzfast.dto.response.ProductResponseDTO;
import com.winzfast.dto.response.ResponseDTO;
import com.winzfast.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/products")
public class ProductRestController {
    @Autowired
    private ProductService productService;
    @PostMapping("/create")
    public ResponseEntity<ProductResponseDTO> createProduct(@RequestBody ProductRequestDTO productRequestDTO){
        ProductResponseDTO productResponseDTO= productService.createProduct(productRequestDTO);
        return new ResponseEntity<>(productResponseDTO, HttpStatus.CREATED);
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<ProductResponseDTO> updateProduct(@PathVariable Long id, @RequestBody ProductRequestDTO productRequestDTO) {
        ProductResponseDTO productResponseDTO = productService.updateProduct(id,productRequestDTO);
        if (productRequestDTO != null) {
            return new ResponseEntity<>(productResponseDTO, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @DeleteMapping("/{id}")
    public ResponseDTO deleteProduct(@PathVariable Long id) {
        return productService.delete(id);
    }

//    @PostMapping("/search")
//    public ResponseDTO searchProducts(@RequestBody SearchRequestDTO searchRequestDTO) {
//        return productService.search(searchRequestDTO);
//    }

    @PostMapping("/{id}/increase-views")
    public ResponseDTO increaseProductViews(@PathVariable Long id) {
        return productService.increaseViews(id);
    }




}
