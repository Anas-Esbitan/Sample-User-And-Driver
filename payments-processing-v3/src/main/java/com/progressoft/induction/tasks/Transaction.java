package com.progressoft.induction.tasks;

import java.time.LocalDate;

public class Transaction {
    private String uniqueId;
    private String customerId;
    private double amount;
    private String paymentType;
    private LocalDate transactionDate;

    public Transaction(String uniqueId, String customerId, double amount, String paymentType, LocalDate transactionDate) {
        this.uniqueId = uniqueId;
        this.customerId = customerId;
        this.amount = amount;
        this.paymentType = paymentType;
        this.transactionDate = transactionDate;
    }

    public String getUniqueId() {
        return uniqueId;
    }

    public String getCustomerId() {
        return customerId;
    }

    public double getAmount() {
        return amount;
    }

    public String getPaymentType() {
        return paymentType;
    }

    public LocalDate getTransactionDate() {
        return transactionDate;
    }
}
