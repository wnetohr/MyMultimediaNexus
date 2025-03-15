package com.washington.neto.MyMultimediaNexus.controller;

import com.washington.neto.MyMultimediaNexus.model.Game;
import com.washington.neto.MyMultimediaNexus.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class FrontendController {

    private final GameService gameService;

    @Autowired
    public FrontendController(GameService gameService) {
        this.gameService = gameService;
    }

    @GetMapping("/")
    public String home(Model model) {
        return "index";
    }

    @GetMapping("/game-list.html")
    public String gameList(Model model) {
        model.addAttribute("games", gameService.getAllGames());
        return "game-list";
    }

    @GetMapping("/games/new")
    public String newGameForm(Model model) {
        model.addAttribute("game", new Game());
        return "new-game";
    }

    @PostMapping("/games")
    public String createGame(Game game) {
        gameService.createGame(game);
        return "redirect:/game-list.html";
    }

    @GetMapping("/games/edit/{id}")
    public String editGameForm(@PathVariable Long id, Model model) {
        Game game = gameService.getGameById(id).orElseThrow(() -> new RuntimeException("Game not found"));
        model.addAttribute("game", game);
        return "edit-game";
    }

    @PostMapping("/games/update/{id}")
    public String updateGame(@PathVariable Long id, Game gameDetails) {
        gameService.updateGame(id, gameDetails);
        return "redirect:/game-list.html";
    }

    @GetMapping("/games/delete/{id}")
    public String deleteGame(@PathVariable Long id) {
        gameService.deleteGame(id);
        return "redirect:/game-list.html";
    }

    @GetMapping("/games/details/{id}")
    public String gameDetails(@PathVariable Long id, Model model) {
        Game game = gameService.getGameById(id).orElseThrow(() -> new RuntimeException("Game not found"));
        model.addAttribute("game", game);
        return "game-details";
    }
}