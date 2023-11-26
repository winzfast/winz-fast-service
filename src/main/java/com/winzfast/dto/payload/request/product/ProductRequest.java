package com.winzfast.dto.payload.request.product;

import com.winzfast.entity.Specification;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Date;

/**
 * @author ADMIN
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductRequest {

    private Long id;
    private String title;
    private String thumbnail;
    private LocalDateTime productDate;
    private String price;
    private int view;
    private Long user;
    private Long category;
    private Specification specification;
    private boolean isDelete;

}
