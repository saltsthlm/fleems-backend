package com.lans.fleems.client.controller;


import com.lans.fleems.client.model.Client;
import com.lans.fleems.client.model.ClientDto;
import com.lans.fleems.client.model.ClientResponseDto;
import com.lans.fleems.client.model.CreateClientDto;
import com.lans.fleems.client.service.ClientService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.UUID;

@RestController
@CrossOrigin
@RequestMapping("${api.base-path}${api.controllers.clients}")
@AllArgsConstructor
public class ClientController {

    private final ClientService clientService;
    @Value("${api.base-path}${api.controllers.clients}/")
    public static String API_CONTEXT_ROOT;

    @GetMapping
    public ResponseEntity<List<ClientResponseDto>> getAllClients() {
        List<Client> clients = clientService.getAllClients();
        return ResponseEntity.ok(clients.stream().map(ClientResponseDto::fromClient).toList());
    }

    @GetMapping("/{clientId}")
    public ResponseEntity<ClientResponseDto> getClientById(@PathVariable UUID clientId) {
        Client client = clientService.getClientById(clientId);
        return ResponseEntity.ok(ClientResponseDto.fromClient(client));
    }

    @DeleteMapping("/{clientId}")
    public ResponseEntity<Void> deleteClientById(@PathVariable UUID clientId) {
        clientService.deleteClientById(clientId);
        return ResponseEntity.noContent().build();
    }

    @PutMapping
    public ResponseEntity<ClientResponseDto> updateClient(@RequestBody ClientDto clientDto) {
        Client client = clientService.updateClient(new Client(clientDto));
        return ResponseEntity.ok(ClientResponseDto.fromClient(client));
    }

    @PostMapping
    public ResponseEntity<ClientResponseDto> createClient(@RequestBody CreateClientDto clientDto) {
        Client createdClient = clientService.createClient(new Client(clientDto));
        ClientResponseDto clientResponseDto = ClientResponseDto.fromClient(createdClient);
        return ResponseEntity.created(URI.create(API_CONTEXT_ROOT + createdClient.getId())).body(clientResponseDto);
    }
}
