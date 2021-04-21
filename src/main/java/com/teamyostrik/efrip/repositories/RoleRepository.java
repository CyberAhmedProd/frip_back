package com.teamyostrik.efrip.repositories;


import org.springframework.data.mongodb.repository.MongoRepository;

import com.teamyostrik.efrip.models.Role;


public interface RoleRepository extends MongoRepository<Role, String> {

	Role findByRole(String role);
}
