package com.test.winzfast.dto.payload.request.product;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author ADMIN
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SearchRequest {

    private String title;
    private String brand;
    private String carModel;

}
