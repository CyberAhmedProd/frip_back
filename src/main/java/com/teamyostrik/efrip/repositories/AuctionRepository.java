package com.teamyostrik.efrip.repositories;

import com.teamyostrik.efrip.models.Auction;
import com.teamyostrik.efrip.models.Product;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AuctionRepository extends MongoRepository<Auction,String> {
    Optional<Auction> findByProduct(Product product);
}
