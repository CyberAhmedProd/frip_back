package com.teamyostrik.efrip.repositories;


import org.springframework.data.mongodb.repository.MongoRepository;

import com.teamyostrik.efrip.models.User;
public interface UserRepository extends MongoRepository<User, String> {
	User findByEmail(String email);
}