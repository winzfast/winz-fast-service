package com.test.winzfast.dto.payload.request.product;

import com.test.winzfast.model.Category;
import com.test.winzfast.model.Specification;
import com.test.winzfast.model.User;

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
public class ProductRequest {

    private String title;
    private String thumbnail;
    private Date productDate;
    private String price;
    private int view;
    private boolean isDelete;
    private Long user;
    private Long category;
    private Long specification;

}

