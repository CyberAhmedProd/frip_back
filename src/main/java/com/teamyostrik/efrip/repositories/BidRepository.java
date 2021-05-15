package com.teamyostrik.efrip.repositories;

import com.teamyostrik.efrip.models.Bid;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BidRepository extends MongoRepository<Bid,String> {
}
