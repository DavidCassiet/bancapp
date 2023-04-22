package org.example.entity;

import java.util.ArrayList;

public class Branch {
    private int id;
    private String name;
    private String address;
    private ArrayList<Client> clients;

    public Branch(int id, String name, String address) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.clients = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public ArrayList<Client> getClients() {
        return clients;
    }

    public void setClients(ArrayList<Client> clients) {
        this.clients = clients;
    }
}
