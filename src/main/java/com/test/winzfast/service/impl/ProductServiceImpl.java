package com.test.winzfast.service.impl;

import com.test.winzfast.converter.product.ProductConverter;
import com.test.winzfast.dto.payload.request.product.ProductRequest;
import com.test.winzfast.dto.payload.request.product.SearchRequest;
import com.test.winzfast.dto.payload.response.product.ProductResponse;
import com.test.winzfast.dto.payload.response.product.Response;
import com.test.winzfast.model.Category;
import com.test.winzfast.model.Product;
import com.test.winzfast.model.User;
import com.test.winzfast.repository.CategoryRepository;
import com.test.winzfast.repository.ProductRepository;
import com.test.winzfast.repository.UserRepository;
import com.test.winzfast.service.ProductService;
import jakarta.persistence.EntityExistsException;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * @author ADMIN
 */
@Service
@AllArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final ProductConverter productConverter;
    private final CategoryRepository categoryRepository;
    private final UserRepository userRepository;

    @Override
    public ProductResponse createProduct(ProductRequest productRequest) {
        Product product = new Product();
        return getProductResponse(productRequest, product);
    }

    @Override
    public ProductResponse updateProduct(Long id, ProductRequest productRequest) {
        Optional<Product> optionalProduct = productRepository.findById(id);
        if (optionalProduct.isEmpty()) {
            throw new RuntimeException("Product not found with id" + id);
        }
        Product product = optionalProduct.get();
        return getProductResponse(productRequest, product);
    }

    private ProductResponse getProductResponse(ProductRequest productRequest, Product product) {
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

        return productConverter.convertToProductResponse(product);
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
       String keyword = "%" + searchRequest.getTitle() + "%";
       List<Product> foundProducts = productRepository.searchInProductAndSpecifications(keyword);

       if(!foundProducts.isEmpty()){
           return new Response("Found products", foundProducts, HttpStatus.OK.value());
       } else {
           return new Response("Not found products", null, HttpStatus.OK.value());
       }
    }

    @Override
    public Response increaseViews(Long id) {
        Response responseDTO=new Response();
        Product product=productRepository.findById(id).orElseThrow(EntityExistsException::new);
        int currentView= product.getView();
        currentView+=1;
        product.setView(currentView);
        productRepository.save(product);
        responseDTO.setMessage("OK");
        responseDTO.setStatus(HttpStatus.OK.value());
        return responseDTO;
    }

}