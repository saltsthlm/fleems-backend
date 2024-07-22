package com.lans.fleems.client;


import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("${api.base-path}${api.controllers.clients}")
@AllArgsConstructor
public class ClientController {

    private final ClientService clientService;
    @Value("${api.base-path}${api.controllers.clients}/")
    public String API_CONTEXT_ROOT;

    @GetMapping
    public ResponseEntity<List<ClientResponseDto>> getAllClients() {
        List<Client> clients = clientService.getAllClients();
        return ResponseEntity.ok(clients.stream().map(ClientResponseDto::fromClient).toList());
    }

    @GetMapping("/{clientId}")
    public ResponseEntity<ClientResponseDto> getClientById(@PathVariable String clientId) {
        Client client = clientService.getClientById(clientId);
        return ResponseEntity.ok(ClientResponseDto.fromClient(client));
    }

    @PostMapping
    public ResponseEntity<ClientResponseDto> createClient(@RequestBody CreateClientDto clientDto) {
        Client createdClient = clientService.createClient(new Client(clientDto));
        ClientResponseDto clientResponseDto = ClientResponseDto.fromClient(createdClient);
        return ResponseEntity.created(URI.create(API_CONTEXT_ROOT + createdClient.getId())).body(clientResponseDto);
    }
}
