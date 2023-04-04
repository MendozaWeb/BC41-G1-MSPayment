package com.nttdata.MSPayment.repository;

import com.nttdata.MSPayment.model.Payment;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentRepository extends ReactiveMongoRepository<Payment, String> {
}
