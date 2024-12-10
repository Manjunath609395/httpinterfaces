package com.httpinterfaces.demo.instructions;

import lombok.Data;

import java.util.List;

@Data
public class PaymentCDMRequest {
    private String kind;
    private String version;
    private String paymentType;
    private String paymentSubType;
    private List<Transaction> decomposeTransactions;

    @Data
    public static class Transaction {
        private String debitAccount;
        private String debitContraAccount;
        private String creditAccount;
        private String creditContraAccount;
        private String postingType;
        private Locator locator;
    }
}
