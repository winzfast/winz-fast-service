package com.test.winzfast.dto.response;


import com.test.winzfast.model.Product;
import lombok.Data;

@Data
public class SpecificationResponseDTO {
    private Long id;
    private String brand;
    private String carModel;
    private String engine;
    private int year;
    private String fuel;
    private String origin;
    private String gear;
    private int numberOfSeat;
    private Long product;
    private boolean isDelete;
    private String message;
}
