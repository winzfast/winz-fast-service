package com.winzfast.dto.request.product;

import com.winzfast.model.Specification;

import lombok.Data;

import java.util.Date;

@Data
public class ProductRequest {
    private Long id;
    private String title;
    private String thumbnail;
    private Date productDate;
    private String price;
    private int view;
    private Long user;
    private Long category;
    private Specification specification;
    private boolean isDelete;
}
