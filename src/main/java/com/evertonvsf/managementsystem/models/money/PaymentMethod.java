package com.evertonvsf.managementsystem.models.money;


public enum PaymentMethod {
    CASH("CASH"),
    DEBIT_CARD("DEBIT CARD"),
    CREDIT_CARD("CREDIT CARD"),
    BANK_TRANSFER("BANK TRANSFER"),
    PIX("PIX");
    private final String method;

    PaymentMethod(String method) {
        this.method = method;
    }

    public String getMethod() {
        return method;
    }
}
