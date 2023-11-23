package com.test.winzfast.dto.payload.request.product;

import com.test.winzfast.model.Product;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author ADMIN
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SpecificationRequest {

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
