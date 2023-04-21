package org.example.entity;

import java.util.ArrayList;

public class Branch {
    private static int id = 0;
    private String name;
    private String address;
    private ArrayList<Client> clients;

    public Branch(String name, String address) {
        id++;
        this.name = name;
        this.address = address;
        this.clients = new ArrayList<>();
    }

    public static int getId() {
        return id;
    }

    public static void setId(int id) {
        Branch.id = id;
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
