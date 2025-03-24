package com.progressoft.induction.tasks;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PaymentProcessorTest {

    private PaymentProcessor processor;

    @BeforeEach
    void setUp() {
        processor = null;// TODO: initialize this with your implementation
    }

    @Test
    void testCreditCardProcessing() {
        double calculatedFee = processor.calculateFee(new Transaction("1", "customer-114", 100, "CREDIT_CARD", LocalDate.now()));
        assertEquals(2.5, calculatedFee, 0.01);
    }

    @Test
    void testBankTransferProcessing() {
        double calculatedFee = processor.calculateFee(new Transaction("1", "customer-115", 100, "TRANSFER", LocalDate.now()));
        assertEquals(1.2, calculatedFee, 0.01);
    }

    @Test
    void testBankTransferProcessingMinCase() {
        double calculatedFee = processor.calculateFee(new Transaction("1", "customer-115", 10, "TRANSFER", LocalDate.now()));
        assertEquals(0.5, calculatedFee, 0.01);
    }

    @Test
    void testDigitalWalletProcessing() {
        double calculatedFee = processor.calculateFee(new Transaction("1", "customer-116", 100, "WALLET", LocalDate.now()));
        assertEquals(2.1, calculatedFee, 0.01);
    }

    @Test
    void testTransactionHistory() {
        LocalDate twoMonthsAgo = LocalDate.now().minusMonths(2);
        LocalDate aWeekBefore = LocalDate.now().minusDays(7);
        LocalDate today = LocalDate.now();

        processor.recordTransaction(new Transaction("1", "customer-117", 6000, "CREDIT_CARD", twoMonthsAgo));
        processor.recordTransaction(new Transaction("2", "customer-117", 50, "WALLET", aWeekBefore));
        processor.recordTransaction(new Transaction("3", "customer-117", 185, "CREDIT_CARD", today));
        processor.recordTransaction(new Transaction("4", "customer-118", 185, "CREDIT_CARD", today));

        assertEquals(235, processor.getTotalTransactionsLastMonth("customer-117"));
    }

    @Test
    void testTransactionHistoryDiscountDoesNotApply() {
        processor.recordTransaction(new Transaction("1", "customer-119", 3000, "CREDIT_CARD", LocalDate.now()));
        processor.recordTransaction(new Transaction("2", "customer-120", 2500, "WALLET", LocalDate.now()));
        processor.recordTransaction(new Transaction("3", "customer-119", 185, "CREDIT_CARD", LocalDate.now()));

        double calculatedFee = processor.calculateFee(new Transaction("4", "customer-119", 100, "CREDIT_CARD", LocalDate.now()));

        assertEquals(2.5, calculatedFee, 0.01);
    }

    @Test
    void testTransactionHistoryDiscountDoesApply() {
        processor.recordTransaction(new Transaction("1", "customer-121", 1800, "WALLET", LocalDate.now()));
        processor.recordTransaction(new Transaction("2", "customer-121", 2500, "WALLET", LocalDate.now()));
        processor.recordTransaction(new Transaction("3", "customer-121", 2000, "TRANSFER", LocalDate.now()));

        double calculatedFee = processor.calculateFee(new Transaction("4", "customer-121", 100, "CREDIT_CARD", LocalDate.now()));

        assertEquals(2.375, calculatedFee, 0.01);
    }
}
