package org.example.repository;

import org.example.entity.Client;

import java.util.ArrayList;

public interface ClientRepository {
    ArrayList<Client> clients = new ArrayList<>();

    default Client getClientById(String clientId) {
        for (Client actualClient : clients) {
            if (actualClient.getId().equals(clientId)) {
                return actualClient;
            }
        }
        return null;
    }
}
