package com.example.dealshare.project.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name ="product")
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="id")
    private int id;
    @Column(name ="name")
    private String name;
    @Column(name ="description")
    private String description;

    @Column(name ="category_id")
    private int category_id;

    @Column(name = "price")
    private int price;
    @Column(name ="photo")
    private String photo;

}
