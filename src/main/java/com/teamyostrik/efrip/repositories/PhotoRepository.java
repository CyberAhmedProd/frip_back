package com.teamyostrik.efrip.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.teamyostrik.efrip.models.Photo;
@Repository
public interface PhotoRepository extends MongoRepository<Photo, String>{

}
