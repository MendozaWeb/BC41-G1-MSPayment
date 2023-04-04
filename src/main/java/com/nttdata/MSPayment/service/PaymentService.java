package com.nttdata.MSPayment.service;

import com.nttdata.MSPayment.model.Movements;
import reactor.core.publisher.Mono;
public interface PaymentService {
    public Mono<Movements> payCredit(String idCredit, Double amount);
}
