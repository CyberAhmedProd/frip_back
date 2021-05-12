package com.teamyostrik.efrip.repositories;

import com.teamyostrik.efrip.models.Category;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends MongoRepository<Category,String> {
    Category findByName(String name);
}
