package com.winzfast.service.impl;

import com.winzfast.converter.product.NewsConverter;
import com.winzfast.dto.payload.request.product.NewsRequest;
import com.winzfast.dto.payload.response.product.NewsResponse;
import com.winzfast.dto.payload.response.Response;
import com.winzfast.model.Category;
import com.winzfast.model.Product;
import com.winzfast.model.Specification;
import com.winzfast.model.User;
import com.winzfast.repository.CategoryRepository;
import com.winzfast.repository.ProductRepository;
import com.winzfast.repository.SpecificationRepository;
import com.winzfast.repository.UserRepository;
import com.winzfast.service.NewsService;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class NewsServiceImpl implements NewsService {
    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;
    private final UserRepository userRepository;
    private final SpecificationRepository specificationRepository;
    private final NewsConverter newsConverter;

    @Override
    public List<Product> getAllNews() {
        return productRepository.findAllWithSpecifications();
    }

    @Override
    public NewsResponse createNews(NewsRequest newsRequest) {


        Product product = new Product();
        product.setTitle(newsRequest.getTitle());
        product.setThumbnail(newsRequest.getThumbnail());
        product.setProductDate(newsRequest.getProductDate());
        product.setPrice(newsRequest.getPrice());
        product.setView(newsRequest.getView());
        Long userId = newsRequest.getUser();
        User user = userRepository.findById(userId).orElse(null);
        product.setUser(user);
        Long categoryId = newsRequest.getCategory();
        Category category = categoryRepository.findById(categoryId).orElse(null);
        product.setCategory(category);
        productRepository.save(product);
        if (product.getId() == null) {
            throw new RuntimeException("Product to create failed!");
        }
        Long productId = product.getId();
        Specification specification = new Specification();
        specification.setBrand(newsRequest.getBrand());
        specification.setCarModel(newsRequest.getCarModel());
        specification.setEngine(newsRequest.getEngine());
        specification.setYear(newsRequest.getYear());
        specification.setFuel(newsRequest.getFuel());
        specification.setOrigin(newsRequest.getOrigin());
        specification.setGear(newsRequest.getGear());
        specification.setNumberOfSeat(newsRequest.getNumberOfSeat());
        product = productRepository.findById(productId).orElse(null);
        specification.setProduct(product);
        specificationRepository.save(specification);
        if (product != null) {
            return newsConverter.getNewsResponseDTO(product, specification);
        }
        return new NewsResponse("Create successfully!", true);
    }

    @Override
    @Transactional
    public Response delete(Long id) {
        Optional<Product> product = productRepository.findById(id);
        if (product.isPresent()) {
            Product foundProduct = product.get();
            foundProduct.setDelete(true);
            productRepository.save(foundProduct);
            List<Specification> specifications = specificationRepository.findByProductId(id);
            for (Specification specification:specifications){
                specification.setDelete(true);
                specificationRepository.save(specification);
            }
            return new Response("Product delete successfully!", null, HttpStatus.OK.value(), true);
        } else {
            return new Response("Product delete false", null, HttpStatus.NOT_FOUND.value(), false);
        }
    }
}
