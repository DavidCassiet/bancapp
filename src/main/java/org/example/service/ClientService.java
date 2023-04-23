package org.example.service;

import org.example.entity.Client;
import org.example.exception.MyException;
import org.example.repository.ClientRepository;

import java.util.ArrayList;

public class ClientService implements ClientRepository {
    private static final ArrayList<Client> clients = ClientRepository.clients;

    public Client createClient(String id, String name, String password, String address) {
        Client objClient = new Client(id, name, password, address);
        clients.add(objClient);

        return objClient;
    }

    public Client getClientById(String clientId) throws MyException{
        for (Client actualClient : clients) {
            if (actualClient.getId().equals(clientId)) {
                return actualClient;
            }
        }
        throw new MyException("Cliente no encontrado.");
    }

    public ArrayList<Client> getClients() {
        return clients;
    }

    public void updateClient(String clientId, String password, String address) throws MyException {
        Client objClient = getClientById(clientId);
        objClient.setPassword(password);
        objClient.setAddress(address);
    }

    public void deleteClient(String clientId) throws MyException {
        Client objClient = getClientById(clientId);
        clients.remove(objClient);
    }
}
