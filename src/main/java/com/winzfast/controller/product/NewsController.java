package com.winzfast.controller.product;

import com.winzfast.dto.payload.request.product.NewsRequest;
import com.winzfast.dto.payload.request.product.ProductRequest;
import com.winzfast.dto.payload.request.product.SpecificationRequest;
import com.winzfast.dto.payload.response.Response;
import com.winzfast.dto.payload.response.product.*;
import com.winzfast.model.Product;
import com.winzfast.model.Specification;
import com.winzfast.service.NewsService;
import com.winzfast.service.ProductService;
import com.winzfast.service.SpecificationService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/news")
@CrossOrigin(origins = "*")
@AllArgsConstructor
public class NewsController {
    private final NewsService newsService;
    private final SpecificationService specificationService;
    private final ProductService productService;

    @GetMapping("")
    public ResponseEntity<List<Product>> getAllNews() {
        List<Product> products = newsService.getAllNews();
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<NewsResponse> createNews(@RequestBody NewsRequest newsRequest) {
        NewsResponse newsResponse = newsService.createNews(newsRequest);
        return new ResponseEntity<>(newsResponse, HttpStatus.CREATED);
    }

    @PutMapping("/specification/{id}")
    public ResponseEntity<SpecificationResponse> updateSpecification(@PathVariable Long id, @RequestBody SpecificationRequest specificationRequest) {
        SpecificationResponse specificationResponseDTO = specificationService.updateSpecification(id, specificationRequest);
        if (specificationRequest != null) {
            return new ResponseEntity<>(specificationResponseDTO, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/product/{id}")
    public ResponseEntity<ProductResponse> updateProduct(@PathVariable Long id, @RequestBody ProductRequest productRequestDTO) {
        ProductResponse productResponseDTO = productService.updateProduct(id, productRequestDTO);
        if (productRequestDTO != null) {
            return new ResponseEntity<>(productResponseDTO, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/delete/{id}")
    public Response deleteNews(@PathVariable Long id) {
        return newsService.delete(id);
    }

    @GetMapping("/search")
    public ResponseEntity<CommonResponse<ProductResponse>> searchProducts(
            @RequestParam(name = "title", required = false) String title,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "price") String sortBy) {

        Pageable pageable = PageRequest.of(page, size, Sort.by(sortBy).ascending());
        CommonResponse<ProductResponse> commonResponse = productService.searchAll(title, pageable);
        return new ResponseEntity<>(commonResponse, HttpStatus.OK);
    }

    @PostMapping("/{id}/increase-views")
    public Response increaseProductViews(@PathVariable Long id) {
        return productService.increaseViews(id);
    }

    @GetMapping("/sort")
    public ResponseEntity<List<Specification>> getSorted(@RequestParam(required = false) String sortBy,
                                                         @RequestParam(required = false, name = "brand") String brand,
                                                         @RequestParam(required = false, name = "carModel") String carModel) {
        List<Specification> sorted = specificationService.sort(sortBy, brand, carModel);
        return new ResponseEntity<>(sorted, HttpStatus.OK);
    }
}
