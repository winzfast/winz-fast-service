package com.winzfast.repository;


import com.winzfast.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {
   @Query("SELECT p FROM Product p LEFT JOIN FETCH p.specifications WHERE p.id = :productId")
   List<Product> findAllWithSpecifications(@Param("productId") Long productId);

   Page<Product> findByTitleLike(String title, Pageable pageable);
   Page<Product> findByPriceBetween(Integer minPrice, Integer maxPrice, Pageable pageable);

   Page<Product> findByPriceGreaterThanEqual(Integer minPrice, Pageable pageable);

   Page<Product> findByPriceLessThanEqual(Integer maxPrice, Pageable pageable);
}