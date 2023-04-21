package org.example.entity;

import org.example.enums.TransactionType;

public class Transfer extends Transaction {
    private String recipientCBU;

    public Transfer(String id, TransactionType type, double amount, String branchId, String accountCBU, String recipientCBU) {
        super(id, type, amount, branchId, accountCBU);
        this.recipientCBU = recipientCBU;
    }

    public String getRecipientCBU() {
        return recipientCBU;
    }

    public void setRecipientCBU(String recipientCBU) {
        this.recipientCBU = recipientCBU;
    }
}