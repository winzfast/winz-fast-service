package com.test.winzfast.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


/**
 * @author ADMIN
 */
@Entity
@Table(name = "specifications")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Specification {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    @OneToMany(mappedBy = "specification")
    private List<Product> products;

    @Column(name = "is_deleted")
    private boolean isDelete;
}
