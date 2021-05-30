package com.teamyostrik.efrip.repositories;


import com.teamyostrik.efrip.models.Product;
import com.teamyostrik.efrip.models.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends MongoRepository<Product, String> {
    List<Product> findAllByUser(User user);
   
}
