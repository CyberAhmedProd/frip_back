package com.teamyostrik.efrip.repositories;


import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.teamyostrik.efrip.models.Role;

@Repository
public interface RoleRepository extends MongoRepository<Role, String> {

	Role findByRole(String role);
}
