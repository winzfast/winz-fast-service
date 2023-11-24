package com.winzfast.dto.payload.response.product;

import com.winzfast.model.Category;
import com.winzfast.model.Specification;
import com.winzfast.model.User;
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
