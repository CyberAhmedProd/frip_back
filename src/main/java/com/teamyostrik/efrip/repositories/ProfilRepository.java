package com.teamyostrik.efrip.repositories;

import java.util.Optional;

import org.springframework.data.domain.Example;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.teamyostrik.efrip.models.Profil;
import com.teamyostrik.efrip.models.User;

@Repository
public interface ProfilRepository extends MongoRepository<Profil, String>{
	
	Optional<Profil> findByUser(User user);
}
