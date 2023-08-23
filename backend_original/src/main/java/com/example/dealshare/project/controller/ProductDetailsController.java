package com.example.dealshare.project.controller;

import com.example.dealshare.project.model.ProductVariant;
import com.example.dealshare.project.service.ProductDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class ProductDetailsController {
    @Autowired
    private ProductDetailsService productDetailsService;

    @GetMapping("/productvariant/{sku}")
    public Optional<ProductVariant> getProductDetails(@PathVariable String sku){
        return productDetailsService.getProductVariant(sku);
    }

    @GetMapping("/product={id}/productvariant")
    public Optional<List<ProductVariant>> getAllProductVariant(@PathVariable int id){
        return productDetailsService.getAllProductVariant(id);
    }


}
