package com.test.winzfast.repository;


import com.test.winzfast.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author ADMIN
 */
public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findByTitleContaining(String title);
}
