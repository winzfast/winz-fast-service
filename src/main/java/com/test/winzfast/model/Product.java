package com.test.winzfast.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.List;


@Entity
@Table(name = "product")
@Getter
@Setter
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
    @JsonIgnore
    private User user;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "category_id")
    private Category category;

    @OneToMany(mappedBy = "product")
    @JsonIgnore
    private List<Specification> specifications;

    @PrePersist
    protected void onCreate() {
        this.productDate = new Date();
    }
}
