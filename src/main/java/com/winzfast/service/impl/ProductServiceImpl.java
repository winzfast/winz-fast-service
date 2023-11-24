package com.winzfast.service.impl;


import com.winzfast.converter.ProductConverter;
import com.winzfast.dto.payload.request.product.ProductRequest;
import com.winzfast.dto.payload.request.product.SearchRequest;
import com.winzfast.dto.payload.response.product.CommonResponse;
import com.winzfast.dto.payload.response.product.PageResponse;
import com.winzfast.dto.payload.response.product.ProductResponse;
import com.winzfast.dto.payload.response.product.Response;
import com.winzfast.model.Category;
import com.winzfast.model.Product;
import com.winzfast.model.User;
import com.winzfast.repository.CategoryRepository;
import com.winzfast.repository.ProductRepository;
import com.winzfast.repository.UserRepository;
import com.winzfast.service.ProductService;
import jakarta.persistence.EntityExistsException;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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

//    @Override
//    public Response search(SearchRequest searchRequest) {
//        String keyword = "%" + searchRequest.getTitle() + "%";
//        List<Product> foundProducts = productRepository.searchByTitleAndSpecification(keyword);
//
//        if(!foundProducts.isEmpty()){
//            return new Response("Found products", foundProducts, HttpStatus.OK.value());
//        } else {
//            return new Response("Not found products", null, HttpStatus.NOT_FOUND.value());
//        }
//    }

    @Override
    public CommonResponse<ProductResponse> searchAll(String title, Pageable pageable) {
        Page<Product> products=productRepository.findByTitleLike('%' +title+ '%', pageable);
        List<Product> productList=products.toList();
        List<ProductResponse> productResponses= productConverter.getProductListDTO(productList);
        PageResponse<ProductResponse> pageResponse =new PageResponse<>();
        pageResponse.setContent(productResponses);
        pageResponse.setPage(products.getNumber());
        pageResponse.setSize(products.getSize());
        pageResponse.setTotalPage(products.getTotalElements());
        pageResponse.setTotalElements(products.getTotalElements());
        CommonResponse<ProductResponse> commonResponse = new CommonResponse<>();
        commonResponse.setMessage("Product Found");
        commonResponse.setStatus(true);
        commonResponse.setData(pageResponse);

        return null;
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