package com.teamyostrik.efrip.repositories;


import com.teamyostrik.efrip.models.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface UserRepository extends MongoRepository<User, String> {
	User findByEmail(String email);
	User findByUsername(String username);
}
