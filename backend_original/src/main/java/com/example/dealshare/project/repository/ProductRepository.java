package com.example.dealshare.project.repository;

import com.example.dealshare.project.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product,Integer> {
    @Query(value = "SELECT * FROM product WHERE product.category_id = ?1", nativeQuery = true)
    List<Product> findBycategory_id(int category_id);

//    @Query(value = "select * from product left join (SELECT tbl1.Price, tbl.product_id FROM product_variant tbl INNER JOIN (SELECT product_id, MIN(price) Price FROM product_variant GROUP BY product_id) tbl1 ON tbl1.product_id = tbl.product_id WHERE tbl1.Price = tbl.price) pro on product.id = pro.product_id", nativeQuery = true)
//    List<Product> findAllMinPrice();
    Optional<Product> findByName(String name);
}
