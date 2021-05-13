package com.teamyostrik.efrip.repositories;

import com.teamyostrik.efrip.models.Product;
import com.teamyostrik.efrip.models.User;
import com.teamyostrik.efrip.models.WishList;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface WishlistRepository extends MongoRepository<WishList,String> {
    List<WishList> findAllByUser(User user) ;
    Optional<WishList> findByProductAndUser(Product product, User user);
}
