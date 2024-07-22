package com.lans.fleems.client;


import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("${api.base-path}${api.controllers.games}")
@AllArgsConstructor
public class ClientController {

    private final ClientService clientService;
    @Value("${api.base-path}${api.controllers.games}/")
    public String API_CONTEXT_ROOT;

    @GetMapping
    public ResponseEntity<List<ClientResponseDto>> getAllClients() {
        List<Client> games = service.getAllGames();
        return ResponseEntity.ok(games.stream().map(GameDTO::fromGame).toList());
    }

    @GetMapping("/{gameId}")
    public ResponseEntity<GameDTO> getGameById(@PathVariable String gameId) {
        Game game = service.getGameById(gameId);
        return ResponseEntity.ok(GameDTO.fromGame(game));
    }

    @PostMapping
    public ResponseEntity<GameDTO> createGame(@RequestBody AddGameDTO gameDto) {
        Team homeTeam = service.getOrCreateTeam(gameDto.homeTeam());
        Team awayTeam = service.getOrCreateTeam(gameDto.awayTeam());

        Game game = new Game(
                gameDto.date(),
                homeTeam,
                awayTeam,
                gameDto.homeScore(),
                gameDto.awayScore(),
                gameDto.attendance(),
                gameDto.referee()
        );

        Game createdGame = service.createGame(game);

        GameDTO dto = GameDTO.fromGame(createdGame);
        return ResponseEntity.created(URI.create(API_CONTEXT_ROOT + createdGame.getId())).body(dto);
    }
}
}
