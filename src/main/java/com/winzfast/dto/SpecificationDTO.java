package com.winzfast.dto;

import com.winzfast.entity.Product;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SpecificationDTO {

    private Long id;

    private String brand;

    private String carModel;

    private String engine;

    private int year;

    private String fuel;

    private String origin;

    private String gear;

    private int numberOfSeat;

    private Product product;

}
