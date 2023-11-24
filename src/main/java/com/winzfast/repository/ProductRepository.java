package com.winzfast.repository;


import com.winzfast.model.Product;
import com.winzfast.model.Specification;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.math.BigDecimal;
import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {
//   List<Product> searchByTitleAndSpecification(String title, String brand, String carModel);
//    @Query("SELECT p FROM Product p JOIN p.specifications s " +
//            "WHERE CONCAT(p.title,'',s.brand,'',s.carModel,'',p.price) LIKE %?1%")
   Page<Product> findByTitleLike(String title, Pageable pageable);
//@Query("SELECT p FROM Product p JOIN p.specification " + "s WHERE p.title LIKE %?1% OR " + "s.brand LIKE %?1% OR" + " s.carModel LIKE %?1%")
//List<Product> searchInProductAndSpecifications(String keyword);
}