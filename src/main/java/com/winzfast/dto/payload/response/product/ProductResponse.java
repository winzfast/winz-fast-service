package com.winzfast.dto.payload.response.product;

import com.winzfast.entity.Category;
import com.winzfast.entity.Specification;
import com.winzfast.entity.User;
import lombok.*;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

/**
 * @author ADMIN
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductResponse {

    private Long id;
    private String title;
    private String thumbnail;
    private LocalDateTime productDate;
    private String price;
    private int view;
    private Long category;
    private Long user;
    private List<Specification> specifications;
    private boolean isDelete;


}
