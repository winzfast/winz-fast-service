package com.winzfast.dto.response.product;


import lombok.Data;

@Data
public class SpecificationResponse {
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
