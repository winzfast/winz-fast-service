package com.winzfast.repository;


import com.winzfast.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
//    List<Product> findByTitleAndSpecificationsBrandAndSpecificationsCarModel(@Param("title") String title,
//                                                                             @Param("brand") String brand,
//                                                                             @Param("carModel") String carModel);

}
