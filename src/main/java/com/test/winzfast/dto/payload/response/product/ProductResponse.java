package com.test.winzfast.dto.payload.response.product;

import com.test.winzfast.model.Category;
import com.test.winzfast.model.Specification;
import com.test.winzfast.model.User;
import lombok.Data;

import java.util.Date;

/**
 * @author ADMIN
 */
@Data
public class ProductResponse {

    private Long id;
    private String title;
    private String thumbnail;
    private Date productDate;
    private String price;
    private int view;
    private Long category;
    private Long user;
    private Specification specification;
    private boolean isDelete;
    private String message;

}
