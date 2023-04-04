package com.nttdata.MSPayment.service;

import java.util.Date;

import com.nttdata.MSPayment.model.Credit;
import com.nttdata.MSPayment.model.Movements;
import com.nttdata.MSPayment.proxy.PaymentProxy;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class PaymentServiceImpl implements PaymentService{

    private final PaymentProxy paymentProxy = new PaymentProxy();

    @Override
    public Mono<Movements> payCredit(String idCredit, Double amount) {

        return paymentProxy.getCredit(idCredit)
                .flatMap(resp->payDebt(resp, amount))
                .flatMap(paymentProxy::updateCredit)
                .flatMap(resp->saveMovement(idCredit, "credit pay", amount));

    }


    //AVTIVEPAYMENT UTIL METHODS
    public Mono<Credit> payDebt(Credit credit, Double amount) {

        Double debt = credit.getDebt();
        if(amount < debt) {
            credit.setDebt(debt-amount);
        }else {
            credit.setDebt(Double.valueOf(0));
        }
        return Mono.just(credit);
    }

    public Mono<Movements> saveMovement(String idProduct,
                                     String type,
                                     Double amount
                                     ) {

        Movements movement = new Movements();
        movement.setIdProduct(idProduct);
        movement.setType(type);
        movement.setAmount(amount);
        movement.setDate(new Date());

        return paymentProxy.saveMovement(movement);
    }
}