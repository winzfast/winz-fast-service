package com.winzfast.service.impl;

import com.winzfast.converter.ProductConverter;
import com.winzfast.dto.request.ProductRequestDTO;
import com.winzfast.dto.request.SearchRequestDTO;
import com.winzfast.dto.response.ProductResponseDTO;
import com.winzfast.dto.response.ResponseDTO;
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
    public ProductResponseDTO createProduct(ProductRequestDTO productRequestDTO) {
        Product product = new Product();
        return getProductResponseDTO(productRequestDTO, product);
    }

    @Override
    public ProductResponseDTO updateProduct(Long id, ProductRequestDTO productRequestDTO) {
        Optional<Product> optionalProduct = productRepository.findById(id);
        if (optionalProduct.isEmpty()) {
            throw new RuntimeException("Product not found with id" + id);
        }
        Product product = optionalProduct.get();
        return getProductResponseDTO(productRequestDTO, product);
    }

    private ProductResponseDTO getProductResponseDTO(ProductRequestDTO productRequestDTO, Product product) {
        product.setTitle(productRequestDTO.getTitle());
        product.setThumbnail(productRequestDTO.getThumbnail());
        product.setProductDate(productRequestDTO.getProductDate());
        product.setPrice(productRequestDTO.getPrice());
        product.setDelete(productRequestDTO.isDelete());
        Long categoryId = productRequestDTO.getCategory();
        Category category = categoryRepository.findById(categoryId).orElse(null);
        product.setCategory(category);
        Long userId = productRequestDTO.getUser();
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
    public ResponseDTO delete(Long id) {
        Optional<Product> product=productRepository.findById(id);
        if (product.isPresent()){
            Product foundProduct= product.get();
            foundProduct.setDelete(true);
            productRepository.save(foundProduct);
        return new ResponseDTO("Product delete successfully!", null, HttpStatus.OK.value(), true);
        } else {
            return new ResponseDTO("Product delete false", null, HttpStatus.NOT_FOUND.value(), false);
        }
    }

    @Override
    public ResponseDTO search(SearchRequestDTO searchRequestDTO) {
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
    public ResponseDTO increaseViews(Long id) {
        ResponseDTO responseDTO=new ResponseDTO();
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