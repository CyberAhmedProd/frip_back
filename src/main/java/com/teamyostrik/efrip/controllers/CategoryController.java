package com.teamyostrik.efrip.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.teamyostrik.efrip.models.Category;
import com.teamyostrik.efrip.services.CategoryService;

import java.util.List;
import java.util.Optional;


@CrossOrigin(origins = "*")
@RestController
@RequestMapping(path = "/api/category")
public class CategoryController {
    private final CategoryService categoryService;

    @Autowired
    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }
    @GetMapping
    public List<Category> getAllCategories(){
        return categoryService.getAllCategories();
    }
    @GetMapping (path = "{categoryid}")
    public Optional<Category> getCategory(@PathVariable ("categoryid") String id){
        return categoryService.getCategory(id);
    }
    @PostMapping
    public void addCategory(@RequestBody Category category){
        categoryService.addCategory(category);
    }
    @DeleteMapping(path ="{categoryid}")
    public void deleteCategory(@PathVariable ("categoryid") String id) {
        categoryService.deleteCategory(id);
    }
    @PostMapping(path = "{categoryid}")
    public void updateCategory(@PathVariable ("categoryid") String id, Category category) {
        categoryService.updateCategory(id, category);
    }

}
