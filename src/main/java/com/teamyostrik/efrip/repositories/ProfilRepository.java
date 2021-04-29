package com.teamyostrik.efrip.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.teamyostrik.efrip.models.Profil;

@Repository
public interface ProfilRepository extends MongoRepository<Profil, String>{
	
}
