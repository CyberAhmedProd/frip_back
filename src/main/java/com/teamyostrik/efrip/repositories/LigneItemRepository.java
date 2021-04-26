package com.teamyostrik.efrip.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.teamyostrik.efrip.models.LigneItem;

public interface LigneItemRepository extends MongoRepository<LigneItem, String>{

}
