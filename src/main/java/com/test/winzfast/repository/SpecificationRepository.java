package com.test.winzfast.repository;


import com.test.winzfast.model.Specification;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SpecificationRepository extends JpaRepository<Specification,Long> {
    List<Specification> findByBrand(String brand);

    List<Specification> findByCarModel(String carModel);

    List<Specification> findByBrandAndCarModelContaining(String brand, String carModel);

}
