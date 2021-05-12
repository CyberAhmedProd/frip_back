package com.teamyostrik.efrip.repositories;

import com.teamyostrik.efrip.models.Profil;
import com.teamyostrik.efrip.models.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProfilRepository extends MongoRepository<Profil, String>{
	
	Optional<Profil> findByUser(User user);
	void deleteByUser(User user);
}
