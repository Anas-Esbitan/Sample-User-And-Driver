package com.progressoft.induction.tasks;

import java.util.List;

public interface PaymentProcessor {

    /**
     * stores user transactions (same them in memory)
     *
     * @param transaction
     */
    void recordTransaction(Transaction transaction);

    /**
     * return the customer total transactions amount in the last month
     *
     * @param customerId
     * @return
     */
    double getTotalTransactionsLastMonth(String customerId);

    /**
     * @param transaction
     * @return
     */
    double calculateFee(Transaction transaction);

    /**
     * compares and verifies the transactionList with the stored customer transactions, the returned result should show
     * the status of each transaction in the transactionList
     *
     * @param transactionList
     * @param customerId
     * @return
     */
    ReconciliationResult reconcileTransactions(List<Transaction> transactionList, String customerId);
}

