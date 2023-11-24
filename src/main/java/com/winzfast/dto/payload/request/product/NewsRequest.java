package com.winzfast.dto.payload.request.product;

import com.winzfast.model.Specification;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.Date;

@Data
public class NewsRequest {
    private Long id;
    private String title;
    private String thumbnail;
    private Date productDate;
    private String price;
    private int view;
    private Long user;
    private Long category;
    private Specification specification;
    private String brand;
    private String carModel;
    private String engine;
    private int year;
    private String fuel;
    private String origin;
    private String gear;
    private int numberOfSeat;
    private Long product;
}
