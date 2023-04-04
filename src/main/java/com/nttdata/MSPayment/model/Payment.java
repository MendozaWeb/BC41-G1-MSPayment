package com.nttdata.MSPayment.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Document("payment")
public class Payment {
    @Id
    private String id;
    private String idCredit;
    private Float amount;
    private String date;
    private PaymentType paymentType;
}
