package org.example.entity;

import org.example.enums.TransactionType;

import java.util.Date;

public class Transaction {
    private String id;
    private Date date;
    private TransactionType type;
    private double amount;
    private String branchId;
    private String accountCBU;

    public Transaction(String id, TransactionType type, double amount, String branchId, String accountCBU) {
        this.id = id;
        this.date = new Date();
        this.type = type;
        this.amount = amount;
        this.branchId = branchId;
        this.accountCBU = accountCBU;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public TransactionType getType() {
        return type;
    }

    public void setType(TransactionType type) {
        this.type = type;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getBranchId() {
        return branchId;
    }

    public void setBranchId(String branchId) {
        this.branchId = branchId;
    }

    public String getAccountCBU() {
        return accountCBU;
    }

    public void setAccountCBU(String accountCBU) {
        this.accountCBU = accountCBU;
    }
}
