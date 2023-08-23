package com.example.dealshare.project.repository;

import com.example.dealshare.project.model.ProductVariant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface ProductVariantRepository extends JpaRepository<ProductVariant, String> {
    @Query(value = "Select * from product_variant where product_id =?1", nativeQuery = true)
    Optional<List<ProductVariant>> findByproduct_id(int id) ;
}
