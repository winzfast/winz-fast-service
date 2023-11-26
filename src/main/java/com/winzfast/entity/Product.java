package com.winzfast.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table
@Getter
@Setter
@Builder
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
    @CreationTimestamp
    private LocalDateTime productDate;
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
    @JoinColumn(name = "category_id")
    @JsonIgnore
    private Category category;
    @OneToMany(mappedBy = "product" )
    private List<Specification> specifications;
}
