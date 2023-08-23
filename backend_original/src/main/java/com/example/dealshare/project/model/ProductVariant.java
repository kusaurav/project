package com.example.dealshare.project.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name ="product_variant")
@NoArgsConstructor
@AllArgsConstructor
public class ProductVariant {
    @Id
    @Column(name ="sku")
    private String sku;

    @Column(name ="name")
    private String name;

    @Column(name ="price")
    private int price;

    @Column(name ="product_id")
    private int product_id;

    @Column(name ="image_url1")
    private String image_url1;
    @Column(name ="image_url2")
    private String image_url2;
    @Column(name ="image_url3")
    private String image_url3;

    @Column(name ="quantity")
    private int quantity;

}
