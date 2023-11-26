package com.winzfast.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.winzfast.entity.Category;
import com.winzfast.entity.Specification;
import com.winzfast.entity.User;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductDTO {
    private Long id;
    private String title;
    private String thumbnail;
    private LocalDateTime productDate;
    private String price;
    private int view;
    private Category category;
    private User user;
    @JsonIgnore
    private List<Specification> specifications;
}
