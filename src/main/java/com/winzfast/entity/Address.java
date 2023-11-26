package com.winzfast.entity;


import lombok.*;

import javax.persistence.*;


@Entity
@Table
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "street",length = 50)
    private String street;
    @Column(name = "district", length = 50)
    private String district;
    @Column(name = "city",length = 50)
    private String city;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User userId;

}
