package com.teamyostrik.efrip.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.teamyostrik.efrip.models.Photo;

public interface PhotoRepository extends MongoRepository<Photo, String>{

}
