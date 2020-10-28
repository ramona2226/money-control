package org.fasttrackit.moneycontrol.transfer;

import javax.persistence.Id;
import java.time.LocalDate;

public class PaymentTransactionDto {


    @Id
    private Long id;

    private String to;
    private LocalDate date;
    private String description;





}
