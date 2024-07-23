package com.lans.fleems.client.service;

import com.lans.fleems.client.model.Client;
import com.lans.fleems.client.repository.ClientRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class ClientService {

    private final ClientRepository clientRepository;

    public List<Client> getAllClients() {
        return clientRepository.getAllClients();
    }

    public Client getClientById(UUID clientId) {
        return clientRepository.getClientById(clientId);
    }

    public Client createClient(Client client) {
        return clientRepository.createClass(client);
    }

    public void deleteClientById(UUID clientId) {
        clientRepository.deleteById(clientId);
    }

    public Client updateClient(Client client) {
        return clientRepository.updateClient(client);
    }
}
