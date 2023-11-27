package com.test.winzfast.service.impl;


import com.test.winzfast.dto.payload.request.product.SearchRequest;
import com.test.winzfast.dto.payload.response.product.*;
import com.test.winzfast.model.Product;
import com.test.winzfast.model.Specification;
import com.test.winzfast.repository.ProductRepository;
import com.test.winzfast.repository.SpecificationRepository;
import com.test.winzfast.service.ProductService;
import jakarta.persistence.EntityExistsException;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * @author ADMIN
 */
@Service
@AllArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final SpecificationRepository specificationRepository;
    @Override
    public Response delete(Long id) {
        Optional<Product> product = productRepository.findById(id);
        if (product.isPresent()) {
            Product foundProduct = product.get();
            foundProduct.setDelete(true);
            productRepository.save(foundProduct);
            return new Response("Product delete successfully!", null, HttpStatus.OK.value(), true);
        } else {
            return new Response("Product delete false", null, HttpStatus.NOT_FOUND.value(), false);
        }
    }

    @Override
    public ProductSearchResponse search(SearchRequest searchRequestDTO) {
        String temp = "%".concat(searchRequestDTO.getTitle()).concat("%");

        List<Product> foundProducts = productRepository.findAllByTitleLike(temp);

        List<Product> productList = new ArrayList<>();

        for (Product element : foundProducts) {
            List<Specification> specifications = element.getSpecifications();
            for (Specification specification : specifications) {
                if (specification.getBrand().equals(searchRequestDTO.getBrand()) && specification.getCarModel().equals(searchRequestDTO.getCarModel())) {
                    productList.add(element);
                }
            }
        }
        String message = "Search completed";
        int status = 200;
        return new ProductSearchResponse(message, productList, status);
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