package com.test.winzfast.repository;


import com.test.winzfast.model.Product;
import com.test.winzfast.model.Specification;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author ADMIN
 */
public interface SpecificationRepository extends JpaRepository<Specification,Long> {


    List<Specification> findAllByBrandLike(String brand);
    List<Specification> findAllByCarModelLike(String carModel);




}
