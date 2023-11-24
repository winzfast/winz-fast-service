package com.winzfast.dto.payload.response.product;

import com.winzfast.model.Product;
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
    private boolean isDelete;
    private String message;
    private Long product;
}
