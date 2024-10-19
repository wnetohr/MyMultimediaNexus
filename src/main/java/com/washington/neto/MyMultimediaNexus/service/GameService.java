package com.washington.neto.MyMultimediaNexus.service;

import com.washington.neto.MyMultimediaNexus.model.Game;
import com.washington.neto.MyMultimediaNexus.repository.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GameService {

    private final GameRepository gameRepository;

    @Autowired
    public GameService(GameRepository gameRepository) {
        this.gameRepository = gameRepository;
    }

    // Create
    public Game createGame(Game game) {
        return gameRepository.save(game);
    }

    // Read
    public List<Game> getAllGames() {
        return gameRepository.findAll();
    }

    public Optional<Game> getGameById(Long id) {
        return gameRepository.findById(id);
    }

    // Update
    public Game updateGame(Long id, Game gameDetails) {
        Game game = gameRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Game not found with id " + id));
        
        game.setName(gameDetails.getName());
        game.setGenre(gameDetails.getGenre());
        game.setReleaseYear(gameDetails.getReleaseYear());
        game.setDeveloper(gameDetails.getDeveloper());
        
        return gameRepository.save(game);
    }

    // Delete
    public void deleteGame(Long id) {
        Game game = gameRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Game not found with id " + id));
        gameRepository.delete(game);
    }
}
