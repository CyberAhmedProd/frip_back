package com.teamyostrik.efrip.repositories;

import com.teamyostrik.efrip.models.Cart;
import com.teamyostrik.efrip.models.Product;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CartRepository extends MongoRepository<Cart, String> {
    List<Cart> findAllByUser_id(String user_id);
    Optional<Cart> findByProductAndUser_id(Product product, String user_id);
}
