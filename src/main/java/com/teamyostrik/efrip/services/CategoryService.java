package com.teamyostrik.efrip.services;


import com.teamyostrik.efrip.models.Category;
import com.teamyostrik.efrip.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {
    private final CategoryRepository categoryRepository;
    @Autowired
    public CategoryService (CategoryRepository categoryRepository){
        this.categoryRepository = categoryRepository;
    }
    public List<Category> getAllCategories(){
        return categoryRepository.findAll();
    }
    public Optional<Category> getCategory(String id){
        return categoryRepository.findById(id);
    }
    public void addCategory(Category category) {
        categoryRepository.save(category);
    }
    public void deleteCategory(String id){
        categoryRepository.deleteById(id);
    }
    public void updateCategory(String id, Category category) {
    	Optional<Category> categoryData = categoryRepository.findById(id);
    	if(categoryData.isPresent()) {
    		Category categoryUpdate = categoryData.get();
    		categoryUpdate.setName(category.getName());
    		categoryRepository.save(categoryUpdate);
		}

      
    }
    public Category findByName(String name) {
        return this.categoryRepository.findByName(name);
    }
}
