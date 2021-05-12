package com.teamyostrik.efrip.repositories;

import com.teamyostrik.efrip.models.Photo;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface PhotoRepository extends MongoRepository<Photo, String>{

}
