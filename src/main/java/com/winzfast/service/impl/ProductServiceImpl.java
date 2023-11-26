package com.winzfast.service.impl;


import com.winzfast.converter.product.ProductConverter;
import com.winzfast.dto.ProductDTO;
import com.winzfast.dto.payload.request.product.ProductRequest;
import com.winzfast.dto.payload.response.product.CommonResponse;
import com.winzfast.dto.payload.response.product.PageResponse;
import com.winzfast.dto.payload.response.product.ProductResponse;
import com.winzfast.dto.payload.response.Response;
import com.winzfast.entity.Category;
import com.winzfast.entity.Product;
import com.winzfast.entity.User;
import com.winzfast.repository.CategoryRepository;
import com.winzfast.repository.ProductRepository;
import com.winzfast.repository.UserRepository;
import com.winzfast.service.ProductService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import javax.persistence.EntityExistsException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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
    private final ModelMapper modelMapper;

    @Override
    public Iterable<ProductDTO> getAll() {
        Iterable<Product> products = productRepository.findAll();
        List<ProductDTO> productDTOS = new ArrayList<>();
        for (Product product : products) {
            productDTOS.add(modelMapper.map(product, ProductDTO.class));
        }
        return productDTOS;
    }

    @Override
    public ProductResponse updateProduct(Long id, ProductRequest productRequest) {
        Optional<Product> optionalProduct = productRepository.findById(id);
        if (optionalProduct.isEmpty()) {
            throw new RuntimeException("Product not found with id" + id);
        }
        Product product = optionalProduct.get();
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
//    public CommonResponse<ProductResponse> getAllProducts(Pageable pageable) {
//        Page<Product> productPage = productRepository.findAll(pageable);
//        List<ProductResponse> productResponses = productPage
//                .getContent()
//                .stream()
//                .map(productConverter::getProductResponseDTO)
//                .collect(Collectors.toList());
//        PageResponse<ProductResponse> pageResponse = new PageResponse<>();
//        pageResponse.setContent(productResponses);
//        pageResponse.setPage(productPage.getNumber());
//        pageResponse.setSize(productPage.getSize());
//        pageResponse.setTotalPage(productPage.getTotalPages());
//        pageResponse.setTotalElements(productPage.getTotalElements());
//        CommonResponse commonResponse = new CommonResponse<>();
//        commonResponse.setData(pageResponse);
//        commonResponse.setStatus(true);
//        commonResponse.setMessage("Products retrieved successfully");
//        return commonResponse;
//    }
//
//    @Override
//    public CommonResponse<ProductResponse> filterProductByPrice(Integer minPrice, Integer maxPrice, Pageable pageable) {
//        Page<Product> productPage;
//        if (minPrice != null && maxPrice != null) {
//            productPage = productRepository.findByPriceBetween(minPrice, maxPrice, pageable);
//        } else if (minPrice != null) {
//            productPage = productRepository.findByPriceGreaterThanEqual(minPrice, pageable);
//        } else if (maxPrice != null) {
//            productPage = productRepository.findByPriceLessThanEqual(maxPrice, pageable);
//        } else {
//            productPage = productRepository.findAll(pageable);
//        }
//        List<ProductResponse> productResponses = productPage
//                .getContent()
//                .stream()
//                .map(productConverter::getProductResponseDTO)
//                .collect(Collectors.toList());
//        PageResponse<ProductResponse> pageResponse = new PageResponse<>();
//        pageResponse.setContent(productResponses);
//        pageResponse.setPage(productPage.getNumber());
//        pageResponse.setSize(productPage.getSize());
//        pageResponse.setTotalPage(productPage.getTotalPages());
//        pageResponse.setTotalElements(productPage.getTotalElements());
//        CommonResponse commonResponse = new CommonResponse<>();
//        commonResponse.setData(pageResponse);
//        commonResponse.setStatus(true);
//        commonResponse.setMessage("Filtered products retrieved successfully");
//        return commonResponse;
//    }
//
//    @Override
//    public CommonResponse<ProductResponse> searchAll(String title, Pageable pageable) {
//        Page<Product> products = productRepository.findByTitleLike('%' + title + '%', pageable);
//        List<Product> productList = products.toList();
//        List<ProductResponse> productResponses = productConverter.getProductListDTO(productList);
//        PageResponse<ProductResponse> pageResponse = new PageResponse<>();
//        pageResponse.setContent(productResponses);
//        pageResponse.setPage(products.getNumber());
//        pageResponse.setSize(products.getSize());
//        pageResponse.setTotalPage(products.getTotalElements());
//        pageResponse.setTotalElements(products.getTotalElements());
//        CommonResponse<ProductResponse> commonResponse = new CommonResponse<>();
//        commonResponse.setMessage("Product Found");
//        commonResponse.setStatus(true);
//        commonResponse.setData(pageResponse);
//
//        return null;
//    }

    @Override
    public List<ProductResponse> getProductByCategoryId(Long id) {
        return null;
    }

    @Override
    public Response increaseViews(Long id) {
        Response responseDTO = new Response();
        Product product = productRepository.findById(id).orElseThrow(EntityExistsException::new);
        int currentView = product.getView();
        currentView += 1;
        product.setView(currentView);
        productRepository.save(product);
        responseDTO.setMessage("OK");
        responseDTO.setStatus(HttpStatus.OK.value());
        return responseDTO;
    }

}