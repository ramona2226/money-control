package org.fasttrackit.moneycontrol.transfer;

import java.time.LocalDate;

public class PaymentTransaction {



    private String to;
    // asta ar fi un From
   // private Long userId;
    private LocalDate date;
    private String description;

    // aici la fel poate avea clientul si o separare de bani gen un saving card, care sa fie tot acelasi
    // card dar o parte diferita. oare aatunci ar fi relatia one to many ( si anume un portofel
    // poate contine mai multe buzunare ca sa zic asa?



}
