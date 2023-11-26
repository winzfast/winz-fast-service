package com.winzfast.dto.payload.response.product;

import lombok.*;

/**
 * @author ADMIN
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
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
