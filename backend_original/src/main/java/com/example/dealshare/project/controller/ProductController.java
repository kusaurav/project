package com.example.dealshare.project.controller;

import com.example.dealshare.project.model.Product;
import com.example.dealshare.project.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class ProductController {
    @Autowired
    private ProductService productService;
    @GetMapping("/")
    public List<Product> Products(){
        return productService.getAllProducts();
    }

    @GetMapping("/product={product_id}")
    public Optional<Product> getProduct(@PathVariable int product_id){
        return productService.getProduct(product_id);
    }

//    @GetMapping("/product={name}")
//    public Optional<Product> getProduct(@PathVariable String name){
//        return productService.getProduct(name);
//    }

    @PostMapping("/addProduct")
    public String addProduct(@RequestBody  Product product){
        return productService.save(product);
    }

    @PutMapping("/deleteProduct/{id}")
    public String deleteProduct(@PathVariable int id){
        return productService.delete(id);
    }
}
