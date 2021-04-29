package com.teamyostrik.efrip.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.teamyostrik.efrip.models.Address;

@Repository
public interface AddressRepository extends MongoRepository<Address, String>
{
	
}