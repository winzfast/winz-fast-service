package com.winzfast.controller;


import com.winzfast.dto.request.product.ProductRequest;
import com.winzfast.dto.response.product.ProductResponse;
import com.winzfast.dto.response.product.Response;
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
    public ResponseEntity<ProductResponse> createProduct(@RequestBody ProductRequest productRequest){
        ProductResponse productResponse = productService.createProduct(productRequest);
        return new ResponseEntity<>(productResponse, HttpStatus.CREATED);
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<ProductResponse> updateProduct(@PathVariable Long id, @RequestBody ProductRequest productRequest) {
        ProductResponse productResponse = productService.updateProduct(id, productRequest);
        if (productRequest != null) {
            return new ResponseEntity<>(productResponse, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @DeleteMapping("/{id}")
    public Response deleteProduct(@PathVariable Long id) {
        return productService.delete(id);
    }

//    @PostMapping("/search")
//    public ResponseDTO searchProducts(@RequestBody SearchRequestDTO searchRequestDTO) {
//        return productService.search(searchRequestDTO);
//    }

    @PostMapping("/{id}/increase-views")
    public Response increaseProductViews(@PathVariable Long id) {
        return productService.increaseViews(id);
    }




}
