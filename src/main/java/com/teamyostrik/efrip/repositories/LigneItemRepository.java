package com.teamyostrik.efrip.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.teamyostrik.efrip.models.LigneItem;
@Repository
public interface LigneItemRepository extends MongoRepository<LigneItem, String>{

}
