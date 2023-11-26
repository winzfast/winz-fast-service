package com.winzfast.entity;


import lombok.*;

import javax.persistence.*;
import java.util.List;


@Entity
@Table
@Getter
@Setter
@Builder
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
