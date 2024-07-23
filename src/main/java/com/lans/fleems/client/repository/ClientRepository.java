package com.lans.fleems.client.repository;

import com.lans.fleems.client.model.Client;
import com.lans.fleems.error.NoSuchClientException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
@AllArgsConstructor
public class ClientRepository {

    private final IClientRepository iClientRepository;

    public List<Client> getAllClients() {
        return iClientRepository.findAll();
    }

    public Client getClientById(UUID clientId) {
        return iClientRepository.findById(clientId)
                .orElseThrow(NoSuchClientException::new);
    }

    public Client createClass(Client client) {
        return iClientRepository.save(client);
    }

    public void deleteById(UUID clientId) {
        if (!iClientRepository.existsById(clientId)) {
            throw new NoSuchClientException();
        }
        iClientRepository.deleteById(clientId);
    }

    public Client updateClient(Client client) {
        if (!iClientRepository.existsById(client.getId())) {
            throw new NoSuchClientException();
        }
        return iClientRepository.save(client);
    }
}
