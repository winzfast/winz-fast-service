package com.winzfast.service.impl;

import com.winzfast.converter.ProductConverter;
import com.winzfast.dto.request.product.ProductRequest;
import com.winzfast.dto.request.product.SearchRequest;
import com.winzfast.dto.response.product.ProductResponse;
import com.winzfast.dto.response.product.Response;
import com.winzfast.model.Category;
import com.winzfast.model.Product;
import com.winzfast.model.User;
import com.winzfast.repository.CategoryRepository;
import com.winzfast.repository.ProductRepository;
import com.winzfast.repository.SpecificationRepository;
import com.winzfast.repository.UserRepository;
import com.winzfast.service.ProductService;
import jakarta.persistence.EntityExistsException;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final ProductConverter productConverter;
    private final CategoryRepository categoryRepository;
    private final UserRepository userRepository;
    private final SpecificationRepository specificationRepository;

    @Override
    public ProductResponse createProduct(ProductRequest productRequest) {
        Product product = new Product();
        return getProductResponseDTO(productRequest, product);
    }

    @Override
    public ProductResponse updateProduct(Long id, ProductRequest productRequest) {
        Optional<Product> optionalProduct = productRepository.findById(id);
        if (optionalProduct.isEmpty()) {
            throw new RuntimeException("Product not found with id" + id);
        }
        Product product = optionalProduct.get();
        return getProductResponseDTO(productRequest, product);
    }

    private ProductResponse getProductResponseDTO(ProductRequest productRequest, Product product) {
        product.setTitle(productRequest.getTitle());
        product.setThumbnail(productRequest.getThumbnail());
        product.setProductDate(productRequest.getProductDate());
        product.setPrice(productRequest.getPrice());
        product.setDelete(productRequest.isDelete());
        Long categoryId = productRequest.getCategory();
        Category category = categoryRepository.findById(categoryId).orElse(null);
        product.setCategory(category);
        Long userId = productRequest.getUser();
        User user = userRepository.findById(userId).orElse(null);
        product.setUser(user);
        productRepository.save(product);
        return productConverter.getProductResponseDTO(product);
    }
    @Override
    public boolean exists(Long id) {
        return productRepository.existsById(id);
    }

    @Override
    public Response delete(Long id) {
        Optional<Product> product=productRepository.findById(id);
        if (product.isPresent()){
            Product foundProduct= product.get();
            foundProduct.setDelete(true);
            productRepository.save(foundProduct);
        return new Response("Product delete successfully!", null, HttpStatus.OK.value(), true);
        } else {
            return new Response("Product delete false", null, HttpStatus.NOT_FOUND.value(), false);
        }
    }

    @Override
    public Response search(SearchRequest searchRequest) {
        return null;
    }


//    @Override
//    public ResponseDTO search(SearchRequestDTO searchRequestDTO) {
//        List<Product> products = productRepository.findByTitleAndSpecificationsBrandAndSpecificationsCarModel(
//                searchRequestDTO.getTitle(),
//                searchRequestDTO.getBrand(),
//                searchRequestDTO.getCarModel()
//        );
//        if (!products.isEmpty()){
//            return new ResponseDTO("Found products", products, HttpStatus.OK.value());
//        } else {
//            return new ResponseDTO("Not found products", null, HttpStatus.OK.value());
//        }
//    }

    @Override
    public Response increaseViews(Long id) {
        Response response =new Response();
        Product product=productRepository.findById(id).orElseThrow(EntityExistsException::new);
        int currentView= product.getView();
        currentView+=1;
        product.setView(currentView);
        productRepository.save(product);
        response.setMessage("OK");
        response.setStatus(HttpStatus.OK.value());
        return response;
    }

}