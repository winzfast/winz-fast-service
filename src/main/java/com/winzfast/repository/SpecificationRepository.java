package com.winzfast.repository;


import com.winzfast.entity.Specification;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SpecificationRepository extends JpaRepository<Specification,Long> {
    List<Specification> findByProductId(Long id);
    List<Specification> findByBrand(String brand);

    List<Specification> findByCarModel(String carModel);

}
