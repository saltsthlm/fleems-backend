package com.lans.fleems.client;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.NoSuchElementException;
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
                .orElseThrow(NoSuchElementException::new);
    }

    public Client createClass(Client client) {
        return iClientRepository.save(client);
    }

    public void deleteById(UUID clientId) {
        if (iClientRepository.existsById(clientId)) {
            iClientRepository.deleteById(clientId);
        }
        throw new NoSuchElementException();
    }

    public Client updateClient(Client client) {
        if (iClientRepository.existsById(client.getId())) {
            return iClientRepository.save(client);
        }
        throw new NoSuchElementException();
    }
}
