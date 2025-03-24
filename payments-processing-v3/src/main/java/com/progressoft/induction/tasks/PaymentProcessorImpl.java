package com.progressoft.induction.tasks;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author esbai
 */

import java.time.chrono.ChronoLocalDate;
import java.util.ArrayList;
import java.util.List;

public class PaymentProcessorImpl implements PaymentProcessor {
    
    private List<Transaction> transactions = new ArrayList<>();  
    
    @Override
    public void recordTransaction(Transaction transaction) {
        transactions.add(transaction);  
    }

    @Override
    public double getTotalTransactionsLastMonth(String customerId) {
        double total = 0;
        for (Transaction transaction : transactions) {
            ChronoLocalDate lastMonthStart = null;
            
            if (transaction.getCustomerId().equals(customerId) && transaction.getTransactionDate().isAfter(lastMonthStart)) {
                total += transaction.getAmount();
            }
        }
        return total;
    }

    @Override
    public double calculateFee(Transaction transaction) {
        double fee = 0;
        switch (transaction.getPaymentType()) {
            case "credit_card":
                fee = transaction.getAmount() * 0.025; 
                break;
            case "bank_transfer":
                fee = transaction.getAmount() * 0.012; 
                if (fee < 0.50) fee = 0.50; 
                break;
            case "digital_wallet":
                fee = transaction.getAmount() * 0.018 + 0.30; 
                break;
        }
        return fee;
    }

    @Override
    public ReconciliationResult reconcileTransactions(List<Transaction> transactionList, String customerId) {
        List<ReconciliationResult> results = new ArrayList<>();
        for (Transaction transaction : transactionList) {
            boolean isMatched = false;
            for (Transaction storedTransaction : transactions) {
                if (storedTransaction.getUniqueId().equals(transaction.getUniqueId()) &&
                    storedTransaction.getCustomerId().equals(customerId)) {
                    isMatched = true;
                    break;
                }
            }
            results.add(new ReconciliationResult(isMatched));
        }
        return new ReconciliationResult(results);
    }
}
