package com.nttdata.MSPayment.controller;
import com.nttdata.MSPayment.model.Movements;
import com.nttdata.MSPayment.service.PaymentService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@RestController
@RequiredArgsConstructor
@RequestMapping("/active-payment")
public class PaymentController {

    private final PaymentService PaymentService;

    @PostMapping("/pay/{id}")
    public Mono<Movements> pay(@PathVariable("id") String idProduct,
                               @RequestParam Double amount) {

        return PaymentService.payCredit(idProduct, amount);

    }

}