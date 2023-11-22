package com.test.winzfast.dto.payload.request.product;

import com.test.winzfast.model.Category;
import com.test.winzfast.model.Specification;
import com.test.winzfast.model.User;

import lombok.Data;

import java.util.Date;

/**
 * @author ADMIN
 */
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
