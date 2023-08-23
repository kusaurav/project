package com.example.dealshare.project.service;

import com.example.dealshare.project.model.ProductVariant;
import com.example.dealshare.project.repository.ProductVariantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@Service
public class ProductDetailsService {
    @Autowired
    private ProductVariantRepository productVariantRepository;


    public Optional<ProductVariant> getProductVariant(@PathVariable String sku){
        return productVariantRepository.findById(sku);
    }

    public Optional<List<ProductVariant>> getAllProductVariant(@PathVariable int id){
        return productVariantRepository.findByproduct_id(id);
    }

//    public String outofstock(){
//        return productVariantRepository.outofstock();
//    }


}
