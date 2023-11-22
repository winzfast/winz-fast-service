package com.test.winzfast.dto.payload.request.product;

import com.test.winzfast.model.Product;
import lombok.Data;

import java.util.Date;

/**
 * @author ADMIN
 */
@Data
public class SpecificationRequest {

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
