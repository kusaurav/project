package com.example.dealshare.project.controller;
import com.example.dealshare.project.model.Category;
import com.example.dealshare.project.model.Product;
import com.example.dealshare.project.service.CategoryService;
import com.example.dealshare.project.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class CategoryController {
    @Autowired
    private CategoryService categoryService;
    @Autowired
    private ProductService productService;
    @GetMapping("/category={category_id}")
    public List<Product> home(@PathVariable int category_id){
        return productService.getProductByCategory(category_id);
    }

    @GetMapping("/categories")
    public List<Category> getCategory(){
        return categoryService.getCategoryAll();
    }

    @GetMapping(params = "category")
        public Optional<Category> findCategory(@RequestParam Integer id){
            return categoryService.getCategory(id);
        }



    @PostMapping("/addCategory")
    public String addCategory(@RequestBody Category category){
        return categoryService.save(category);
    }
    @PutMapping("/deleteCategory/{id}")
    public String deleteCategory(@PathVariable int id){
        return categoryService.delete(id);
    }

}
