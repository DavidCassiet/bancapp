package org.example.entity;

import java.util.ArrayList;

public class Client {
    private String id;
    private String name;
    private String password;
    private String address;
    private ArrayList<Account> accounts = new ArrayList<>();

    public Client(String id, String name, String password, String address) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.address = address;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public ArrayList<Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(ArrayList<Account> accounts) {
        this.accounts = accounts;
    }

    public void addAccount(Account objAccount) {
        this.accounts.add(objAccount);
    }

    public void removeAccount(Account objAccount) {
        this.accounts.remove(objAccount);
    }
}
