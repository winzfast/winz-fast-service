package com.winzfast.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.winzfast.dto.payload.request.product.NewsRequest;
import lombok.*;
import org.springframework.util.StringUtils;

import javax.persistence.*;


@Entity
@Table(name = "specifications")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Specification {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "brand", length = 50)
    private String brand;
    @Column(name = "car_model", length = 50)
    private String carModel;
    @Column(name = "engine", length = 50)
    private String engine;
    @Column(name = "year", length = 10)
    private int year;
    @Column(name = "fuel", length = 10)
    private String fuel;
    @Column(name = "origin",length = 50)
    private String origin;
    @Column(name = "gear", length = 50)
    private String gear;
    @Column(name = "number_of_seat")
    private int numberOfSeat;
    @Column(name = "is_deleted")
    private boolean isDelete;
    @ManyToOne
    @JoinColumn(name = "product_id")
    @JsonIgnore
    private Product product;

}
