package com.nttdata.MSPayment.proxy;

import com.nttdata.MSPayment.model.Credit;
import com.nttdata.MSPayment.model.Movements;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

public class PaymentProxy {

    private final WebClient.Builder webClientBuilder = WebClient.builder();

    public Mono<Credit> getCredit(String idProduct){
        return webClientBuilder.build()
                .get()
                .uri("http://localhost:9020/credit/" + idProduct)
                .retrieve()
                .bodyToMono(Credit.class);
    }

    public Mono<Credit> updateCredit(Credit credit){
        return webClientBuilder.build()
                .put()
                .uri("http://localhost:9020/credit")
                .contentType(MediaType.APPLICATION_JSON)
                .body(BodyInserters.fromValue(credit))
                .retrieve()
                .bodyToMono(Credit.class);
    }

    public Mono<Movements> saveMovement(Movements movement) {
        return webClientBuilder.build()
                .post()
                .uri("http://localhost:9020/movements")
                .contentType(MediaType.APPLICATION_JSON)
                .body(BodyInserters.fromValue(movement))
                .retrieve()
                .bodyToMono(Movements.class);
    }
}
