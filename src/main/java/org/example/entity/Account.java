package org.example.entity;

import org.example.enums.AccountType;

import java.util.ArrayList;

public class Account {
    private String number;
    private String cbu;
    private double balance = 0;
    private AccountType type;
    private String branchId;
    private String clientId;
    private ArrayList<Transaction> transactions = new ArrayList<>();

    public Account(String number, String cbu, AccountType type, String branchId, String clientId) {
        this.number = number;
        this.cbu = cbu;
        this.type = type;
        this.branchId = branchId;
        this.clientId = clientId;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getCbu() {
        return cbu;
    }

    public void setCbu(String cbu) {
        this.cbu = cbu;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public AccountType getType() {
        return type;
    }

    public void setType(AccountType type) {
        this.type = type;
    }

    public String getBranchId() {
        return branchId;
    }

    public void setBranchId(String branchId) {
        this.branchId = branchId;
    }

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public ArrayList<Transaction> getTransactions() {
        return transactions;
    }

    public void setTransactions(ArrayList<Transaction> transactions) {
        this.transactions = transactions;
    }
}
