package com.teamyostrik.efrip.repositories;

import com.teamyostrik.efrip.models.Address;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends MongoRepository<Address, String>
{
	
}
