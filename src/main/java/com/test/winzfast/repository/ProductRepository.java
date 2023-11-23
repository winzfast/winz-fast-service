package com.test.winzfast.repository;


import com.test.winzfast.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * @author ADMIN
 */
public interface ProductRepository extends JpaRepository<Product, Long> {

    @Query("SELECT p FROM Product p JOIN p.specification " +
            "s WHERE p.title LIKE %?1% OR " +
            "s.brand LIKE %?1% OR" +
            " s.carModel LIKE %?1%")
    List<Product> searchInProductAndSpecifications(String keyword);


}
