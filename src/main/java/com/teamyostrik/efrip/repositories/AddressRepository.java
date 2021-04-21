package com.teamyostrik.efrip.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.teamyostrik.efrip.models.Address;

public interface AddressRepository extends MongoRepository<Address, String>{
	
}
