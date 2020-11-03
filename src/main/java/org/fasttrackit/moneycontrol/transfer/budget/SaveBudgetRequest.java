package org.fasttrackit.moneycontrol.transfer.budget;


import java.time.LocalDate;

public class SaveBudgetRequest {

    private long id;

    private String type;

    private String from;

    private String to;

    private double amount;

    private LocalDate date;

    private String description;

    private String answer;


    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "TransactionResponse{" +
                "id=" + id +
                ", type='" + type + '\'' +
                ", from='" + from + '\'' +
                ", to='" + to + '\'' +
                ", amount=" + amount +
                ", date=" + date +
                ", description='" + description + '\'' +
                '}';
    }
}


//    @NotNull
//    private long id;
//
//    @NotNull
//    private double balance;
//
//    @NotNull
//    private String valuteName;
//
//
//    private String answer;
//
//    public long getId() {
//        return id;
//    }
//
//    public void setId(long id) {
//        this.id = id;
//    }
//
//    public double getBalance() {
//        return balance;
//    }
//
//    public void setBalance(double balance) {
//        this.balance = balance;
//    }
//
//    public String getValuteName() {
//        return valuteName;
//    }
//
//    public void setValuteName(String valuteName) {
//        this.valuteName = valuteName;
//    }
//
//    public String getAnswer() {
//        return answer;
//    }
//
//    public void setAnswer(String answer) {
//        this.answer = answer;
//    }
//
//    @Override
//    public String toString() {
//        return "SaveBudgetRequest{" +
//                "id=" + id +
//                ", balance=" + balance +
//                ", valuteName='" + valuteName + '\'' +
//                ", answer='" + answer + '\'' +
//                '}';
//    }
