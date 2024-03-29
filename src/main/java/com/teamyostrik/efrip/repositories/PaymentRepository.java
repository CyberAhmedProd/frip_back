package com.teamyostrik.efrip.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.teamyostrik.efrip.models.Payment;

@Repository
public interface PaymentRepository extends MongoRepository<Payment, String>{

}
