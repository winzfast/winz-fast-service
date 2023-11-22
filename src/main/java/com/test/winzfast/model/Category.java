package com.test.winzfast.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;


@Entity
@Table
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "logo")
    private String logo;
    @Column(name = "name", length = 50)
    private String name;
    @OneToMany(mappedBy = "category")
    private List<Product> products;
}
