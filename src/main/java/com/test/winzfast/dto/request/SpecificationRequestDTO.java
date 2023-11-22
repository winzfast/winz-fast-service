package com.test.winzfast.dto.request;

import com.test.winzfast.model.Product;
import lombok.Data;

import java.util.Date;

@Data
public class SpecificationRequestDTO {
    private Long id;
    private String brand;
    private String carModel;
    private String engine;
    private int year;
    private String fuel;
    private String origin;
    private String gear;
    private int numberOfSeat;
    private boolean isDelete;
    private Long product;

}
