package com.teamyostrik.efrip.repositories;

import com.teamyostrik.efrip.models.Cart;
import com.teamyostrik.efrip.models.Product;
import com.teamyostrik.efrip.models.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@Repository
public interface CartRepository extends MongoRepository<Cart, String> {
    List<Cart> findAllByUser(User user);
    Optional<Cart> findByProductAndUser(Product product, User user);
    void deleteByUser(User user);
}
