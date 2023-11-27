package com.test.winzfast.controller;

import com.test.winzfast.dto.payload.request.product.ProductRequest;
import com.test.winzfast.dto.payload.request.product.SearchRequest;
import com.test.winzfast.dto.payload.response.product.ProductResponse;
import com.test.winzfast.dto.payload.response.product.ProductSearchResponse;
import com.test.winzfast.dto.payload.response.product.Response;
import com.test.winzfast.model.Product;
import com.test.winzfast.service.ProductService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ADMIN
 */
@RestController
@RequestMapping("/api/products")
@RequiredArgsConstructor
public class ProductRestController {

    private final ProductService productService;

//    @PostMapping("/create")
//    public ResponseEntity<ProductResponse> createProduct(@RequestBody ProductRequest productRequestDTO){
//        ProductResponse productResponseDTO= productService.createProduct(productRequestDTO);
//        return new ResponseEntity<>(productResponseDTO, HttpStatus.CREATED);
//    }
//
//    @PutMapping("/update/{id}")
//    public ResponseEntity<ProductResponse> updateProduct(@PathVariable Long id, @RequestBody ProductRequest productRequestDTO) {
//        ProductResponse productResponseDTO = productService.updateProduct(id,productRequestDTO);
//        if (productRequestDTO != null) {
//            return new ResponseEntity<>(productResponseDTO, HttpStatus.OK);
//        } else {
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
//    }

    @DeleteMapping("/{id}")
    public Response deleteProduct(@PathVariable Long id) {
        return productService.delete(id);
    }
//    @GetMapping("/searchs")
//    public List<Product> searchProductsByTitle(@RequestParam(value = "title") String title) {
//        return productService.searchByTitle(title);
//    }
@GetMapping("/search")
public ResponseEntity<ProductSearchResponse> searchProducts(@RequestParam("title") String title,
                                                            @RequestParam("brand") String brand,
                                                            @RequestParam("carModel") String carModel) {
    SearchRequest searchRequest = new SearchRequest(title, brand, carModel);
    ProductSearchResponse response = productService.search(searchRequest);

    if (response.getProducts().isEmpty()) {
        String message = "No products found for the given criteria";
        int status = 404;
        return ResponseEntity.status(status).body(new ProductSearchResponse(message, new ArrayList<>(), status));
    }

    return new ResponseEntity<>(response,HttpStatus.OK);
}

    @PostMapping("/{id}/increase-views")
    public Response increaseProductViews(@PathVariable Long id) {
        return productService.increaseViews(id);
    }

}
