package com.teamyostrik.efrip.repositories;

import com.teamyostrik.efrip.models.LigneItem;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface LigneItemRepository extends MongoRepository<LigneItem, String>{

}
