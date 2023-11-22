package com.test.winzfast.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;


@Entity
@Table
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "title", length = 50)
    private String title;
    @Column(name = "thumbnail")
    private String thumbnail;
    @Column(name = "product_date", length = 50)
    private Date productDate;
    @Column(name = "price")
    private String price;
    @Column(name = "view")
    private int view;
    @Column(name = "is_deleted")
    private boolean isDelete;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;
    @OneToMany(mappedBy = "product")
    private List<Specification> specifications;

}
