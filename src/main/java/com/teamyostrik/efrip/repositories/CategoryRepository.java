package com.teamyostrik.efrip.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.teamyostrik.efrip.models.Category;

@Repository
public interface CategoryRepository extends MongoRepository<Category,String> {
    Category findByName(String name);
}
