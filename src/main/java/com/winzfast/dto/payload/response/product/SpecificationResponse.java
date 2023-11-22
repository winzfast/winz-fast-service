package com.winzfast.dto.payload.response.product;

import lombok.Data;

/**
 * @author ADMIN
 */
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
