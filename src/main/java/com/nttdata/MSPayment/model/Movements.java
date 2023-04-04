package com.nttdata.MSPayment.model;

import java.util.Date;
import lombok.Data;
@Data
public class Movements {
    private String id;
    private String idProduct;
    private String type;
    private Double amount;
    private Date date;
}
