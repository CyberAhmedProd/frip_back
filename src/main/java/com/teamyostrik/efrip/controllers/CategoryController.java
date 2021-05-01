package com.teamyostrik.efrip.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.teamyostrik.efrip.models.Category;
import com.teamyostrik.efrip.services.CategoryService;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import static org.springframework.http.ResponseEntity.ok;


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
    public ResponseEntity<HashMap<Object,Object>> addCategory(@RequestBody Category category){

        Category categoryNameExists = categoryService.findCategoryByName(category.getName());
        HashMap<Object,Object> model = new HashMap<>();
        if(categoryNameExists != null){
            model.put("success",1);
            model.put("message","category "+category.getName()+" added successfully");
            categoryService.addCategory(category);
        }
        else {
            model.put("success",0);
            model.put("message","Category already Exists !");
        }
        return ok(model);


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
