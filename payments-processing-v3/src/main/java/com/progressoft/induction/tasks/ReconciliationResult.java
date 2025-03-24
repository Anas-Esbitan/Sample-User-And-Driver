package com.progressoft.induction.tasks;

import java.util.List;

/**
 * This class should contain detailed result of the reconciliation process
 */



public class ReconciliationResult {
    private boolean isMatched;
    private String message;

    public ReconciliationResult(List<ReconciliationResult> isMatched) {
        this.isMatched = isMatched;
        this.message = message;
    }

    public boolean isMatched() {
        return isMatched;
    }

    public String getMessage() {
        return message;
    }
}
