package com.test.winzfast.controller;

import com.test.winzfast.dto.payload.request.product.ProductRequest;
import com.test.winzfast.dto.payload.request.product.SearchRequest;
import com.test.winzfast.dto.payload.response.product.ProductResponse;
import com.test.winzfast.dto.payload.response.product.Response;
import com.test.winzfast.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * @author ADMIN
 */
@RestController
@RequestMapping("/api/products")
@AllArgsConstructor
public class ProductRestController {

    private final ProductService productService;

    @PostMapping("/create")
    public ResponseEntity<ProductResponse> createProduct(@RequestBody ProductRequest productRequestDTO){
        ProductResponse productResponseDTO= productService.createProduct(productRequestDTO);
        return new ResponseEntity<>(productResponseDTO, HttpStatus.CREATED);
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<ProductResponse> updateProduct(@PathVariable Long id, @RequestBody ProductRequest productRequestDTO) {
        ProductResponse productResponseDTO = productService.updateProduct(id,productRequestDTO);
        if (productRequestDTO != null) {
            return new ResponseEntity<>(productResponseDTO, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @DeleteMapping("/{id}")
    public Response deleteProduct(@PathVariable Long id) {
        return productService.delete(id);
    }

    @PostMapping("/search")
    public Response searchProducts(@RequestBody SearchRequest searchRequest) {
        return productService.search(searchRequest);
    }

    @PostMapping("/{id}/increase-views")
    public Response increaseProductViews(@PathVariable Long id) {
        return productService.increaseViews(id);
    }




}
