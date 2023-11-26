package com.winzfast.dto.payload.response.product;

import com.winzfast.entity.Category;
import com.winzfast.entity.User;
import lombok.*;

import java.time.LocalDateTime;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NewsResponse {

    private String title;
    private String thumbnail;
    private LocalDateTime productDate;
    private String price;
    private int view;
    private Long user;
    private Long category;
    private String brand;
    private String carModel;
    private String engine;
    private int year;
    private String fuel;
    private String origin;
    private String gear;
    private int numberOfSeat;
    private Long product;
    private String message;
    private boolean success;
    public NewsResponse (String message,boolean success){

    }

}
