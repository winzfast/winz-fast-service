package com.winzfast.repository;


import com.winzfast.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findByTitleAndSpecificationsBrandAndSpecificationsCarModel(@Param("title") String title,
                                                                             @Param("brand") String brand,
                                                                             @Param("carModel") String carModel);

}
