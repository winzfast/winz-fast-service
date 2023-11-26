package com.winzfast.controller.product;

import com.winzfast.dto.ProductDTO;
import com.winzfast.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/api/products")
@CrossOrigin(origins = "*")
public class ProductController {
    private final ProductService productService;

    @GetMapping("/show")
    public ResponseEntity<Iterable<ProductDTO>> getProducts() {
        return new ResponseEntity<>(productService.getAll(), HttpStatus.OK);
    }

}
