package com.example.dealshare.project.service;

import com.example.dealshare.project.model.Category;
import com.example.dealshare.project.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {
    @Autowired
    private CategoryRepository categoryRepo;
    public List<Category> getCategoryAll(){
        return categoryRepo.findAll();
    }

    public Optional<Category> getCategory(int id){
        return categoryRepo.findById(id);
    }

    public String save(Category category){
        if(categoryRepo.findAll().contains(category)){
            return "Already Added";
        }
        else {
            categoryRepo.saveAndFlush(category);
            return "Added Successfully";
        }
    }

    public String delete(int id){
        if(categoryRepo.findById(id).isEmpty()){
            return "Nothing to delete";
        }
        else {
            categoryRepo.deleteById(id);
            return "Deleted Successfully";
        }
    }
}
