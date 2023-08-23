package com.example.dealshare.project.service;

import com.example.dealshare.project.model.Product;
import com.example.dealshare.project.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;
    public List<Product> getAllProducts(){
        if(productRepository.findAll().isEmpty()){
            return null;
        }
        return productRepository.findAll();
    }
    public Optional<Product> getProduct(int id){
        return productRepository.findById(id);
    }
    //public Optional<Product> getProduct(String name){
//        return productRepository.findByName(name);
//    }

    public List<Product> getProductByCategory(int category_id){
        return productRepository.findBycategory_id(category_id);
    }

    public String save(Product product){
        if(productRepository.findAll().contains(product)){
            return "Already Added";
        }
        productRepository.save(product);
        return "Added Successfully";
    }

    public String delete(int id){
        if(productRepository.findById(id).isEmpty()){
            return "Nothing to delete";
        }
        productRepository.deleteById(id);
        return "Deleted Successfully";
    }

}
